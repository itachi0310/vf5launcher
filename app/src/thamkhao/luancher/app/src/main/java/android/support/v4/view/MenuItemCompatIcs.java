package android.support.v4.view;

import android.view.MenuItem;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/MenuItemCompatIcs.class */
class MenuItemCompatIcs {

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/MenuItemCompatIcs$SupportActionExpandProxy.class */
    interface SupportActionExpandProxy {
        boolean onMenuItemActionExpand(MenuItem menuItem);

        boolean onMenuItemActionCollapse(MenuItem menuItem);
    }

    MenuItemCompatIcs() {
    }

    public static boolean expandActionView(MenuItem item) {
        return item.expandActionView();
    }

    public static boolean collapseActionView(MenuItem item) {
        return item.collapseActionView();
    }

    public static boolean isActionViewExpanded(MenuItem item) {
        return item.isActionViewExpanded();
    }

    public static MenuItem setOnActionExpandListener(MenuItem item, SupportActionExpandProxy listener) {
        return item.setOnActionExpandListener(new OnActionExpandListenerWrapper(listener));
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/MenuItemCompatIcs$OnActionExpandListenerWrapper.class */
    static class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private SupportActionExpandProxy mWrapped;

        public OnActionExpandListenerWrapper(SupportActionExpandProxy wrapped) {
            this.mWrapped = wrapped;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem item) {
            return this.mWrapped.onMenuItemActionExpand(item);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem item) {
            return this.mWrapped.onMenuItemActionCollapse(item);
        }
    }
}
