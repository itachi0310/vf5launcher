package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/EventBus.class */
public class EventBus {
    static volatile EventBus defaultInstance;
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    private final Map<Object, List<Class<?>>> typesBySubscriber;
    private final Map<Class<?>, Object> stickyEvents;
    private final ThreadLocal<PostingThreadState> currentPostingThreadState;
    private final MainThreadSupport mainThreadSupport;
    private final Poster mainThreadPoster;
    private final BackgroundPoster backgroundPoster;
    private final AsyncPoster asyncPoster;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final ExecutorService executorService;
    private final boolean throwSubscriberException;
    private final boolean logSubscriberExceptions;
    private final boolean logNoSubscriberMessages;
    private final boolean sendSubscriberExceptionEvent;
    private final boolean sendNoSubscriberEvent;
    private final boolean eventInheritance;
    private final int indexCount;
    private final Logger logger;
    public static String TAG = "EventBus";
    private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
    private static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();

    /* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/EventBus$PostCallback.class */
    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    public static EventBus getDefault() {
        if (defaultInstance == null) {
            synchronized (EventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new EventBus();
                }
            }
        }
        return defaultInstance;
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    public static void clearCaches() {
        SubscriberMethodFinder.clearCaches();
        eventTypesCache.clear();
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    EventBus(EventBusBuilder builder) {
        this.currentPostingThreadState = new ThreadLocal<PostingThreadState>() { // from class: org.greenrobot.eventbus.EventBus.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public PostingThreadState initialValue() {
                return new PostingThreadState();
            }
        };
        this.logger = builder.getLogger();
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new HashMap();
        this.stickyEvents = new ConcurrentHashMap();
        this.mainThreadSupport = builder.getMainThreadSupport();
        this.mainThreadPoster = this.mainThreadSupport != null ? this.mainThreadSupport.createPoster(this) : null;
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        this.indexCount = builder.subscriberInfoIndexes != null ? builder.subscriberInfoIndexes.size() : 0;
        this.subscriberMethodFinder = new SubscriberMethodFinder(builder.subscriberInfoIndexes, builder.strictMethodVerification, builder.ignoreGeneratedIndex);
        this.logSubscriberExceptions = builder.logSubscriberExceptions;
        this.logNoSubscriberMessages = builder.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = builder.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = builder.sendNoSubscriberEvent;
        this.throwSubscriberException = builder.throwSubscriberException;
        this.eventInheritance = builder.eventInheritance;
        this.executorService = builder.executorService;
    }

    public void register(Object subscriber) {
        Class<?> subscriberClass = subscriber.getClass();
        List<SubscriberMethod> subscriberMethods = this.subscriberMethodFinder.findSubscriberMethods(subscriberClass);
        synchronized (this) {
            for (SubscriberMethod subscriberMethod : subscriberMethods) {
                subscribe(subscriber, subscriberMethod);
            }
        }
    }

    private void subscribe(Object subscriber, SubscriberMethod subscriberMethod) {
        Class<?> eventType = subscriberMethod.eventType;
        Subscription newSubscription = new Subscription(subscriber, subscriberMethod);
        CopyOnWriteArrayList<Subscription> subscriptions = this.subscriptionsByEventType.get(eventType);
        if (subscriptions == null) {
            subscriptions = new CopyOnWriteArrayList<>();
            this.subscriptionsByEventType.put(eventType, subscriptions);
        } else if (subscriptions.contains(newSubscription)) {
            throw new EventBusException("Subscriber " + subscriber.getClass() + " already registered to event " + eventType);
        }
        int size = subscriptions.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || subscriberMethod.priority > subscriptions.get(i).subscriberMethod.priority) {
                subscriptions.add(i, newSubscription);
                break;
            }
        }
        List<Class<?>> subscribedEvents = this.typesBySubscriber.get(subscriber);
        if (subscribedEvents == null) {
            subscribedEvents = new ArrayList();
            this.typesBySubscriber.put(subscriber, subscribedEvents);
        }
        subscribedEvents.add(eventType);
        if (subscriberMethod.sticky) {
            if (this.eventInheritance) {
                Set<Map.Entry<Class<?>, Object>> entries = this.stickyEvents.entrySet();
                for (Map.Entry<Class<?>, Object> entry : entries) {
                    Class<?> candidateEventType = entry.getKey();
                    if (eventType.isAssignableFrom(candidateEventType)) {
                        Object stickyEvent = entry.getValue();
                        checkPostStickyEventToSubscription(newSubscription, stickyEvent);
                    }
                }
                return;
            }
            Object stickyEvent2 = this.stickyEvents.get(eventType);
            checkPostStickyEventToSubscription(newSubscription, stickyEvent2);
        }
    }

    private void checkPostStickyEventToSubscription(Subscription newSubscription, Object stickyEvent) {
        if (stickyEvent != null) {
            postToSubscription(newSubscription, stickyEvent, isMainThread());
        }
    }

    private boolean isMainThread() {
        if (this.mainThreadSupport != null) {
            return this.mainThreadSupport.isMainThread();
        }
        return true;
    }

    public synchronized boolean isRegistered(Object subscriber) {
        return this.typesBySubscriber.containsKey(subscriber);
    }

    private void unsubscribeByEventType(Object subscriber, Class<?> eventType) {
        List<Subscription> subscriptions = this.subscriptionsByEventType.get(eventType);
        if (subscriptions != null) {
            int size = subscriptions.size();
            int i = 0;
            while (i < size) {
                Subscription subscription = subscriptions.get(i);
                if (subscription.subscriber == subscriber) {
                    subscription.active = false;
                    subscriptions.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public synchronized void unregister(Object subscriber) {
        List<Class<?>> subscribedTypes = this.typesBySubscriber.get(subscriber);
        if (subscribedTypes != null) {
            for (Class<?> eventType : subscribedTypes) {
                unsubscribeByEventType(subscriber, eventType);
            }
            this.typesBySubscriber.remove(subscriber);
            return;
        }
        this.logger.log(Level.WARNING, "Subscriber to unregister was not registered before: " + subscriber.getClass());
    }

    public void post(Object event) {
        PostingThreadState postingState = this.currentPostingThreadState.get();
        List<Object> eventQueue = postingState.eventQueue;
        eventQueue.add(event);
        if (!postingState.isPosting) {
            postingState.isMainThread = isMainThread();
            postingState.isPosting = true;
            if (postingState.canceled) {
                throw new EventBusException("Internal error. Abort state was not reset");
            }
            while (!eventQueue.isEmpty()) {
                try {
                    postSingleEvent(eventQueue.remove(0), postingState);
                } catch (Throwable th) {
                    postingState.isPosting = false;
                    postingState.isMainThread = false;
                    throw th;
                }
            }
            postingState.isPosting = false;
            postingState.isMainThread = false;
        }
    }

    public void cancelEventDelivery(Object event) {
        PostingThreadState postingState = this.currentPostingThreadState.get();
        if (!postingState.isPosting) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (event == null) {
            throw new EventBusException("Event may not be null");
        }
        if (postingState.event != event) {
            throw new EventBusException("Only the currently handled event may be aborted");
        }
        if (postingState.subscription.subscriberMethod.threadMode != ThreadMode.POSTING) {
            throw new EventBusException(" event handlers may only abort the incoming event");
        }
        postingState.canceled = true;
    }

    public void postSticky(Object event) {
        synchronized (this.stickyEvents) {
            this.stickyEvents.put(event.getClass(), event);
        }
        post(event);
    }

    public <T> T getStickyEvent(Class<T> eventType) {
        T tCast;
        synchronized (this.stickyEvents) {
            tCast = eventType.cast(this.stickyEvents.get(eventType));
        }
        return tCast;
    }

    public <T> T removeStickyEvent(Class<T> eventType) {
        T tCast;
        synchronized (this.stickyEvents) {
            tCast = eventType.cast(this.stickyEvents.remove(eventType));
        }
        return tCast;
    }

    public boolean removeStickyEvent(Object event) {
        synchronized (this.stickyEvents) {
            Class<?> eventType = event.getClass();
            Object existingEvent = this.stickyEvents.get(eventType);
            if (event.equals(existingEvent)) {
                this.stickyEvents.remove(eventType);
                return true;
            }
            return false;
        }
    }

    public void removeAllStickyEvents() {
        synchronized (this.stickyEvents) {
            this.stickyEvents.clear();
        }
    }

    public boolean hasSubscriberForEvent(Class<?> eventClass) {
        CopyOnWriteArrayList<Subscription> subscriptions;
        List<Class<?>> eventTypes = lookupAllEventTypes(eventClass);
        if (eventTypes != null) {
            int countTypes = eventTypes.size();
            for (int h = 0; h < countTypes; h++) {
                Class<?> clazz = eventTypes.get(h);
                synchronized (this) {
                    subscriptions = this.subscriptionsByEventType.get(clazz);
                }
                if (subscriptions != null && !subscriptions.isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void postSingleEvent(Object event, PostingThreadState postingState) throws Error {
        Class<?> eventClass = event.getClass();
        boolean subscriptionFound = false;
        if (this.eventInheritance) {
            List<Class<?>> eventTypes = lookupAllEventTypes(eventClass);
            int countTypes = eventTypes.size();
            for (int h = 0; h < countTypes; h++) {
                Class<?> clazz = eventTypes.get(h);
                subscriptionFound |= postSingleEventForEventType(event, postingState, clazz);
            }
        } else {
            subscriptionFound = postSingleEventForEventType(event, postingState, eventClass);
        }
        if (!subscriptionFound) {
            if (this.logNoSubscriberMessages) {
                this.logger.log(Level.FINE, "No subscribers registered for event " + eventClass);
            }
            if (this.sendNoSubscriberEvent && eventClass != NoSubscriberEvent.class && eventClass != SubscriberExceptionEvent.class) {
                post(new NoSubscriberEvent(this, event));
            }
        }
    }

    private boolean postSingleEventForEventType(Object event, PostingThreadState postingState, Class<?> eventClass) {
        CopyOnWriteArrayList<Subscription> subscriptions;
        synchronized (this) {
            subscriptions = this.subscriptionsByEventType.get(eventClass);
        }
        if (subscriptions != null && !subscriptions.isEmpty()) {
            for (Subscription subscription : subscriptions) {
                postingState.event = event;
                postingState.subscription = subscription;
                try {
                    postToSubscription(subscription, event, postingState.isMainThread);
                    boolean aborted = postingState.canceled;
                    postingState.event = null;
                    postingState.subscription = null;
                    postingState.canceled = false;
                    if (aborted) {
                        return true;
                    }
                } catch (Throwable th) {
                    postingState.event = null;
                    postingState.subscription = null;
                    postingState.canceled = false;
                    throw th;
                }
            }
            return true;
        }
        return false;
    }

    private void postToSubscription(Subscription subscription, Object event, boolean isMainThread) {
        switch (subscription.subscriberMethod.threadMode) {
            case POSTING:
                invokeSubscriber(subscription, event);
                return;
            case MAIN:
                if (isMainThread) {
                    invokeSubscriber(subscription, event);
                    return;
                } else {
                    this.mainThreadPoster.enqueue(subscription, event);
                    return;
                }
            case MAIN_ORDERED:
                if (this.mainThreadPoster != null) {
                    this.mainThreadPoster.enqueue(subscription, event);
                    return;
                } else {
                    invokeSubscriber(subscription, event);
                    return;
                }
            case BACKGROUND:
                if (isMainThread) {
                    this.backgroundPoster.enqueue(subscription, event);
                    return;
                } else {
                    invokeSubscriber(subscription, event);
                    return;
                }
            case ASYNC:
                this.asyncPoster.enqueue(subscription, event);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + subscription.subscriberMethod.threadMode);
        }
    }

    private static List<Class<?>> lookupAllEventTypes(Class<?> eventClass) {
        List<Class<?>> list;
        synchronized (eventTypesCache) {
            List<Class<?>> eventTypes = eventTypesCache.get(eventClass);
            if (eventTypes == null) {
                eventTypes = new ArrayList();
                for (Class<?> clazz = eventClass; clazz != null; clazz = clazz.getSuperclass()) {
                    eventTypes.add(clazz);
                    addInterfaces(eventTypes, clazz.getInterfaces());
                }
                eventTypesCache.put(eventClass, eventTypes);
            }
            list = eventTypes;
        }
        return list;
    }

    static void addInterfaces(List<Class<?>> eventTypes, Class<?>[] interfaces) {
        for (Class<?> interfaceClass : interfaces) {
            if (!eventTypes.contains(interfaceClass)) {
                eventTypes.add(interfaceClass);
                addInterfaces(eventTypes, interfaceClass.getInterfaces());
            }
        }
    }

    void invokeSubscriber(PendingPost pendingPost) {
        Object event = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        PendingPost.releasePendingPost(pendingPost);
        if (subscription.active) {
            invokeSubscriber(subscription, event);
        }
    }

    void invokeSubscriber(Subscription subscription, Object event) {
        try {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, event);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            handleSubscriberException(subscription, event, e2.getCause());
        }
    }

    private void handleSubscriberException(Subscription subscription, Object event, Throwable cause) {
        if (event instanceof SubscriberExceptionEvent) {
            if (this.logSubscriberExceptions) {
                this.logger.log(Level.SEVERE, "SubscriberExceptionEvent subscriber " + subscription.subscriber.getClass() + " threw an exception", cause);
                SubscriberExceptionEvent exEvent = (SubscriberExceptionEvent) event;
                this.logger.log(Level.SEVERE, "Initial event " + exEvent.causingEvent + " caused exception in " + exEvent.causingSubscriber, exEvent.throwable);
                return;
            }
            return;
        }
        if (this.throwSubscriberException) {
            throw new EventBusException("Invoking subscriber failed", cause);
        }
        if (this.logSubscriberExceptions) {
            this.logger.log(Level.SEVERE, "Could not dispatch event: " + event.getClass() + " to subscribing class " + subscription.subscriber.getClass(), cause);
        }
        if (this.sendSubscriberExceptionEvent) {
            post(new SubscriberExceptionEvent(this, cause, event, subscription.subscriber));
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/EventBus$PostingThreadState.class */
    static final class PostingThreadState {
        final List<Object> eventQueue = new ArrayList();
        boolean isPosting;
        boolean isMainThread;
        Subscription subscription;
        Object event;
        boolean canceled;

        PostingThreadState() {
        }
    }

    ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.indexCount + ", eventInheritance=" + this.eventInheritance + "]";
    }
}
