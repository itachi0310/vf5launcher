package com.android.launcher17;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.syu.ipc.data.FinalCanbus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class FocusHelper {
    private static TabHost findTabHostParent(View v) {
        ViewParent p = v.getParent();
        while (p != null && !(p instanceof TabHost)) {
            p = p.getParent();
        }
        return (TabHost) p;
    }

    static boolean handleAppsCustomizeTabKeyEvent(View v, int keyCode, KeyEvent e) {
        TabHost tabHost = findTabHostParent(v);
        ViewGroup contents = tabHost.getTabContentView();
        View shop = tabHost.findViewById(R.id.market_button);
        int action = e.getAction();
        boolean handleKeyEvent = action != 1;
        switch (keyCode) {
            case 20:
                if (!handleKeyEvent || v != shop) {
                    return false;
                }
                contents.requestFocus();
                return true;
            case 21:
            default:
                return false;
            case 22:
                if (handleKeyEvent && v != shop) {
                    shop.requestFocus();
                }
                return true;
        }
    }

    private static ViewGroup getAppsCustomizePage(ViewGroup container, int index) {
        ViewGroup page = (ViewGroup) ((PagedView) container).getPageAt(index);
        if (page instanceof CellLayout) {
            return ((CellLayout) page).getShortcutsAndWidgets();
        }
        return page;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean handlePagedViewGridLayoutWidgetKeyEvent(PagedViewWidget w, int keyCode, KeyEvent e) {
        View child;
        ViewGroup newParent;
        View child2;
        ViewGroup newParent2;
        View child3;
        PagedViewGridLayout parent = (PagedViewGridLayout) w.getParent();
        PagedView pagedView = (PagedView) parent.getParent();
        TabHost tabHost = findTabHostParent(pagedView);
        TabWidget tabs = tabHost.getTabWidget();
        int widgetIndex = parent.indexOfChild(w);
        int widgetCount = parent.getChildCount();
        int pageIndex = pagedView.indexToPage(pagedView.indexOfChild(parent));
        int pageCount = pagedView.getChildCount();
        int cellCountX = parent.getCellCountX();
        int cellCountY = parent.getCellCountY();
        int x = widgetIndex % cellCountX;
        int y = widgetIndex / cellCountX;
        int action = e.getAction();
        boolean handleKeyEvent = action != 1;
        View child4 = null;
        switch (keyCode) {
            case 19:
                if (handleKeyEvent) {
                    if (y > 0) {
                        int newWidgetIndex = ((y - 1) * cellCountX) + x;
                        View child5 = parent.getChildAt(newWidgetIndex);
                        if (child5 != null) {
                            child5.requestFocus();
                        }
                    } else {
                        tabs.requestFocus();
                    }
                }
                return true;
            case 20:
                if (handleKeyEvent && y < cellCountY - 1) {
                    int newWidgetIndex2 = Math.min(widgetCount - 1, ((y + 1) * cellCountX) + x);
                    View child6 = parent.getChildAt(newWidgetIndex2);
                    if (child6 != null) {
                        child6.requestFocus();
                    }
                }
                return true;
            case 21:
                if (handleKeyEvent) {
                    if (widgetIndex > 0) {
                        parent.getChildAt(widgetIndex - 1).requestFocus();
                    } else if (pageIndex > 0 && (newParent2 = getAppsCustomizePage(pagedView, pageIndex - 1)) != null && (child3 = newParent2.getChildAt(newParent2.getChildCount() - 1)) != null) {
                        child3.requestFocus();
                    }
                }
                return true;
            case 22:
                if (handleKeyEvent) {
                    if (widgetIndex < widgetCount - 1) {
                        parent.getChildAt(widgetIndex + 1).requestFocus();
                    } else if (pageIndex < pageCount - 1 && (newParent = getAppsCustomizePage(pagedView, pageIndex + 1)) != null && (child2 = newParent.getChildAt(0)) != null) {
                        child2.requestFocus();
                    }
                }
                return true;
            case 23:
            case 66:
                if (handleKeyEvent) {
                    View.OnClickListener clickListener = (View.OnClickListener) pagedView;
                    clickListener.onClick(w);
                }
                return true;
            case FinalCanbus.CAR_WC2_DS5LS /* 92 */:
                if (handleKeyEvent) {
                    if (pageIndex > 0) {
                        ViewGroup newParent3 = getAppsCustomizePage(pagedView, pageIndex - 1);
                        if (newParent3 != null) {
                            child4 = newParent3.getChildAt(0);
                        }
                    } else {
                        child4 = parent.getChildAt(0);
                    }
                    if (child4 != null) {
                        child4.requestFocus();
                    }
                }
                return true;
            case FinalCanbus.CAR_HC_XP1_GrdCherokee /* 93 */:
                if (handleKeyEvent) {
                    if (pageIndex < pageCount - 1) {
                        ViewGroup newParent4 = getAppsCustomizePage(pagedView, pageIndex + 1);
                        if (newParent4 != null) {
                            child4 = newParent4.getChildAt(0);
                        }
                    } else {
                        child4 = parent.getChildAt(widgetCount - 1);
                    }
                    if (child4 != null) {
                        child4.requestFocus();
                    }
                }
                return true;
            case FinalCanbus.CAR_WC2_408_14_L /* 122 */:
                if (handleKeyEvent && (child = parent.getChildAt(0)) != null) {
                    child.requestFocus();
                }
                return true;
            case FinalCanbus.CAR_RZC4_PSA301 /* 123 */:
                if (handleKeyEvent) {
                    parent.getChildAt(widgetCount - 1).requestFocus();
                }
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean handleAppsCustomizeKeyEvent(View v, int keyCode, KeyEvent e) {
        ViewGroup parentLayout;
        ViewGroup itemContainer;
        int countX;
        int countY;
        ViewGroup newParent;
        ViewGroup newParent2;
        if (v.getParent() instanceof ShortcutAndWidgetContainer) {
            itemContainer = (ViewGroup) v.getParent();
            parentLayout = (ViewGroup) itemContainer.getParent();
            countX = ((CellLayout) parentLayout).getCountX();
            countY = ((CellLayout) parentLayout).getCountY();
        } else {
            parentLayout = (ViewGroup) v.getParent();
            itemContainer = parentLayout;
            countX = ((PagedViewGridLayout) parentLayout).getCellCountX();
            countY = ((PagedViewGridLayout) parentLayout).getCellCountY();
        }
        PagedView pagedView = (PagedView) parentLayout.getParent();
        TabHost tabHost = findTabHostParent(pagedView);
        TabWidget tabs = tabHost.getTabWidget();
        int iconIndex = itemContainer.indexOfChild(v);
        int itemCount = itemContainer.getChildCount();
        int pageIndex = pagedView.indexToPage(pagedView.indexOfChild(parentLayout));
        int pageCount = pagedView.getChildCount();
        int x = iconIndex % countX;
        int y = iconIndex / countX;
        int action = e.getAction();
        boolean handleKeyEvent = action != 1;
        switch (keyCode) {
            case 19:
                if (handleKeyEvent) {
                    if (y > 0) {
                        int newiconIndex = ((y - 1) * countX) + x;
                        itemContainer.getChildAt(newiconIndex).requestFocus();
                    } else {
                        tabs.requestFocus();
                    }
                }
                return true;
            case 20:
                if (handleKeyEvent && y < countY - 1) {
                    int newiconIndex2 = Math.min(itemCount - 1, ((y + 1) * countX) + x);
                    itemContainer.getChildAt(newiconIndex2).requestFocus();
                }
                return true;
            case 21:
                if (handleKeyEvent) {
                    if (iconIndex > 0) {
                        itemContainer.getChildAt(iconIndex - 1).requestFocus();
                    } else if (pageIndex > 0 && (newParent2 = getAppsCustomizePage(pagedView, pageIndex - 1)) != null) {
                        pagedView.snapToPage(pageIndex - 1);
                        View child = newParent2.getChildAt(newParent2.getChildCount() - 1);
                        if (child != null) {
                            child.requestFocus();
                        }
                    }
                }
                return true;
            case 22:
                if (handleKeyEvent) {
                    if (iconIndex < itemCount - 1) {
                        itemContainer.getChildAt(iconIndex + 1).requestFocus();
                    } else if (pageIndex < pageCount - 1 && (newParent = getAppsCustomizePage(pagedView, pageIndex + 1)) != null) {
                        pagedView.snapToPage(pageIndex + 1);
                        View child2 = newParent.getChildAt(0);
                        if (child2 != null) {
                            child2.requestFocus();
                        }
                    }
                }
                return true;
            case 23:
            case 66:
                if (handleKeyEvent) {
                    View.OnClickListener clickListener = (View.OnClickListener) pagedView;
                    clickListener.onClick(v);
                }
                return true;
            case FinalCanbus.CAR_WC2_DS5LS /* 92 */:
                if (handleKeyEvent) {
                    if (pageIndex > 0) {
                        ViewGroup newParent3 = getAppsCustomizePage(pagedView, pageIndex - 1);
                        if (newParent3 != null) {
                            pagedView.snapToPage(pageIndex - 1);
                            View child3 = newParent3.getChildAt(0);
                            if (child3 != null) {
                                child3.requestFocus();
                            }
                        }
                    } else {
                        itemContainer.getChildAt(0).requestFocus();
                    }
                }
                return true;
            case FinalCanbus.CAR_HC_XP1_GrdCherokee /* 93 */:
                if (handleKeyEvent) {
                    if (pageIndex < pageCount - 1) {
                        ViewGroup newParent4 = getAppsCustomizePage(pagedView, pageIndex + 1);
                        if (newParent4 != null) {
                            pagedView.snapToPage(pageIndex + 1);
                            View child4 = newParent4.getChildAt(0);
                            if (child4 != null) {
                                child4.requestFocus();
                            }
                        }
                    } else {
                        itemContainer.getChildAt(itemCount - 1).requestFocus();
                    }
                }
                return true;
            case FinalCanbus.CAR_WC2_408_14_L /* 122 */:
                if (handleKeyEvent) {
                    itemContainer.getChildAt(0).requestFocus();
                }
                return true;
            case FinalCanbus.CAR_RZC4_PSA301 /* 123 */:
                if (handleKeyEvent) {
                    itemContainer.getChildAt(itemCount - 1).requestFocus();
                }
                return true;
            default:
                return false;
        }
    }

    static boolean handleTabKeyEvent(AccessibleTabView v, int keyCode, KeyEvent e) {
        if (!LauncherAppState.getInstance().isScreenLarge()) {
            return false;
        }
        FocusOnlyTabWidget parent = (FocusOnlyTabWidget) v.getParent();
        TabHost tabHost = findTabHostParent(parent);
        ViewGroup contents = tabHost.getTabContentView();
        int tabCount = parent.getTabCount();
        int tabIndex = parent.getChildTabIndex(v);
        int action = e.getAction();
        boolean handleKeyEvent = action != 1;
        switch (keyCode) {
            case 19:
                return true;
            case 20:
                if (handleKeyEvent) {
                    contents.requestFocus();
                }
                return true;
            case 21:
                if (handleKeyEvent && tabIndex > 0) {
                    parent.getChildTabViewAt(tabIndex - 1).requestFocus();
                }
                return true;
            case 22:
                if (handleKeyEvent) {
                    if (tabIndex < tabCount - 1) {
                        parent.getChildTabViewAt(tabIndex + 1).requestFocus();
                    } else if (v.getNextFocusRightId() != -1) {
                        tabHost.findViewById(v.getNextFocusRightId()).requestFocus();
                    }
                }
                return true;
            default:
                return false;
        }
    }

    static boolean handleHotseatButtonKeyEvent(View v, int keyCode, KeyEvent e, int orientation) {
        ViewGroup parent = (ViewGroup) v.getParent();
        ViewGroup launcher = (ViewGroup) parent.getParent();
        Workspace workspace = (Workspace) launcher.findViewById(R.id.workspace);
        int buttonIndex = parent.indexOfChild(v);
        int buttonCount = parent.getChildCount();
        int pageIndex = workspace.getCurrentPage();
        int action = e.getAction();
        boolean handleKeyEvent = action != 1;
        switch (keyCode) {
            case 19:
                if (handleKeyEvent) {
                    CellLayout layout = (CellLayout) workspace.getChildAt(pageIndex);
                    ShortcutAndWidgetContainer children = layout.getShortcutsAndWidgets();
                    View newIcon = getIconInDirection(layout, children, -1, 1);
                    if (newIcon != null) {
                        newIcon.requestFocus();
                    } else {
                        workspace.requestFocus();
                    }
                }
                return true;
            case 20:
                return true;
            case 21:
                if (handleKeyEvent) {
                    if (buttonIndex > 0) {
                        parent.getChildAt(buttonIndex - 1).requestFocus();
                    } else {
                        workspace.snapToPage(pageIndex - 1);
                    }
                }
                return true;
            case 22:
                if (handleKeyEvent) {
                    if (buttonIndex < buttonCount - 1) {
                        parent.getChildAt(buttonIndex + 1).requestFocus();
                    } else {
                        workspace.snapToPage(pageIndex + 1);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    private static ShortcutAndWidgetContainer getCellLayoutChildrenForIndex(ViewGroup container, int i) {
        ViewGroup parent = (ViewGroup) container.getChildAt(i);
        return (ShortcutAndWidgetContainer) parent.getChildAt(0);
    }

    private static ArrayList<View> getCellLayoutChildrenSortedSpatially(CellLayout layout, ViewGroup parent) {
        final int cellCountX = layout.getCountX();
        int count = parent.getChildCount();
        ArrayList<View> views = new ArrayList<>();
        for (int j = 0; j < count; j++) {
            views.add(parent.getChildAt(j));
        }
        Collections.sort(views, new Comparator<View>() { // from class: com.android.launcher17.FocusHelper.1
            @Override // java.util.Comparator
            public int compare(View lhs, View rhs) {
                CellLayout.LayoutParams llp = (CellLayout.LayoutParams) lhs.getLayoutParams();
                CellLayout.LayoutParams rlp = (CellLayout.LayoutParams) rhs.getLayoutParams();
                int lvIndex = (llp.cellY * cellCountX) + llp.cellX;
                int rvIndex = (rlp.cellY * cellCountX) + rlp.cellX;
                return lvIndex - rvIndex;
            }
        });
        return views;
    }

    private static View findIndexOfIcon(ArrayList<View> views, int i, int delta) {
        int count = views.size();
        int newI = i + delta;
        while (newI >= 0 && newI < count) {
            View newV = views.get(newI);
            if ((newV instanceof BubbleTextView) || (newV instanceof FolderIcon)) {
                return newV;
            }
            newI += delta;
        }
        return null;
    }

    private static View getIconInDirection(CellLayout layout, ViewGroup parent, int i, int delta) {
        ArrayList<View> views = getCellLayoutChildrenSortedSpatially(layout, parent);
        return findIndexOfIcon(views, i, delta);
    }

    private static View getIconInDirection(CellLayout layout, ViewGroup parent, View v, int delta) {
        ArrayList<View> views = getCellLayoutChildrenSortedSpatially(layout, parent);
        return findIndexOfIcon(views, views.indexOf(v), delta);
    }

    private static View getClosestIconOnLine(CellLayout layout, ViewGroup parent, View v, int lineDelta) {
        boolean satisfiesRow;
        ArrayList<View> views = getCellLayoutChildrenSortedSpatially(layout, parent);
        CellLayout.LayoutParams lp = (CellLayout.LayoutParams) v.getLayoutParams();
        int cellCountY = layout.getCountY();
        int row = lp.cellY;
        int newRow = row + lineDelta;
        if (newRow >= 0 && newRow < cellCountY) {
            float closestDistance = Float.MAX_VALUE;
            int closestIndex = -1;
            int index = views.indexOf(v);
            int endIndex = lineDelta < 0 ? -1 : views.size();
            while (index != endIndex) {
                View newV = views.get(index);
                CellLayout.LayoutParams tmpLp = (CellLayout.LayoutParams) newV.getLayoutParams();
                if (lineDelta < 0) {
                    satisfiesRow = tmpLp.cellY < row;
                } else {
                    satisfiesRow = tmpLp.cellY > row;
                }
                if (satisfiesRow && ((newV instanceof BubbleTextView) || (newV instanceof FolderIcon))) {
                    float tmpDistance = (float) Math.sqrt(Math.pow(tmpLp.cellX - lp.cellX, 2.0d) + Math.pow(tmpLp.cellY - lp.cellY, 2.0d));
                    if (tmpDistance < closestDistance) {
                        closestIndex = index;
                        closestDistance = tmpDistance;
                    }
                }
                if (index <= endIndex) {
                    index++;
                } else {
                    index--;
                }
            }
            if (closestIndex > -1) {
                return views.get(closestIndex);
            }
        }
        return null;
    }

    static boolean handleIconKeyEvent(View v, int keyCode, KeyEvent e) {
        View newIcon;
        View newIcon2;
        ShortcutAndWidgetContainer parent = (ShortcutAndWidgetContainer) v.getParent();
        CellLayout layout = (CellLayout) parent.getParent();
        Workspace workspace = (Workspace) layout.getParent();
        ViewGroup launcher = (ViewGroup) workspace.getParent();
        ViewGroup tabs = (ViewGroup) launcher.findViewById(R.id.qsb_bar);
        ViewGroup hotseat = (ViewGroup) launcher.findViewById(R.id.hotseat);
        int pageIndex = workspace.indexOfChild(layout);
        int pageCount = workspace.getChildCount();
        int action = e.getAction();
        boolean handleKeyEvent = action != 1;
        switch (keyCode) {
            case 19:
                if (!handleKeyEvent) {
                    return false;
                }
                View newIcon3 = getClosestIconOnLine(layout, parent, v, -1);
                if (newIcon3 != null) {
                    newIcon3.requestFocus();
                    return true;
                }
                tabs.requestFocus();
                return false;
            case 20:
                if (!handleKeyEvent) {
                    return false;
                }
                View newIcon4 = getClosestIconOnLine(layout, parent, v, 1);
                if (newIcon4 != null) {
                    newIcon4.requestFocus();
                    return true;
                }
                if (hotseat == null) {
                    return false;
                }
                hotseat.requestFocus();
                return false;
            case 21:
                if (handleKeyEvent) {
                    View newIcon5 = getIconInDirection(layout, parent, v, -1);
                    if (newIcon5 != null) {
                        newIcon5.requestFocus();
                    } else if (pageIndex > 0) {
                        ShortcutAndWidgetContainer parent2 = getCellLayoutChildrenForIndex(workspace, pageIndex - 1);
                        View newIcon6 = getIconInDirection(layout, parent2, parent2.getChildCount(), -1);
                        if (newIcon6 != null) {
                            newIcon6.requestFocus();
                        } else {
                            workspace.snapToPage(pageIndex - 1);
                        }
                    }
                }
                return true;
            case 22:
                if (handleKeyEvent) {
                    View newIcon7 = getIconInDirection(layout, parent, v, 1);
                    if (newIcon7 != null) {
                        newIcon7.requestFocus();
                    } else if (pageIndex < pageCount - 1) {
                        View newIcon8 = getIconInDirection(layout, getCellLayoutChildrenForIndex(workspace, pageIndex + 1), -1, 1);
                        if (newIcon8 != null) {
                            newIcon8.requestFocus();
                        } else {
                            workspace.snapToPage(pageIndex + 1);
                        }
                    }
                }
                return true;
            case FinalCanbus.CAR_WC2_DS5LS /* 92 */:
                if (handleKeyEvent) {
                    if (pageIndex > 0) {
                        View newIcon9 = getIconInDirection(layout, getCellLayoutChildrenForIndex(workspace, pageIndex - 1), -1, 1);
                        if (newIcon9 != null) {
                            newIcon9.requestFocus();
                        } else {
                            workspace.snapToPage(pageIndex - 1);
                        }
                    } else {
                        View newIcon10 = getIconInDirection(layout, parent, -1, 1);
                        if (newIcon10 != null) {
                            newIcon10.requestFocus();
                        }
                    }
                }
                return true;
            case FinalCanbus.CAR_HC_XP1_GrdCherokee /* 93 */:
                if (handleKeyEvent) {
                    if (pageIndex < pageCount - 1) {
                        View newIcon11 = getIconInDirection(layout, getCellLayoutChildrenForIndex(workspace, pageIndex + 1), -1, 1);
                        if (newIcon11 != null) {
                            newIcon11.requestFocus();
                        } else {
                            workspace.snapToPage(pageIndex + 1);
                        }
                    } else {
                        View newIcon12 = getIconInDirection(layout, parent, parent.getChildCount(), -1);
                        if (newIcon12 != null) {
                            newIcon12.requestFocus();
                        }
                    }
                }
                return true;
            case FinalCanbus.CAR_WC2_408_14_L /* 122 */:
                if (handleKeyEvent && (newIcon2 = getIconInDirection(layout, parent, -1, 1)) != null) {
                    newIcon2.requestFocus();
                }
                return true;
            case FinalCanbus.CAR_RZC4_PSA301 /* 123 */:
                if (handleKeyEvent && (newIcon = getIconInDirection(layout, parent, parent.getChildCount(), -1)) != null) {
                    newIcon.requestFocus();
                }
                return true;
            default:
                return false;
        }
    }

    static boolean handleFolderKeyEvent(View v, int keyCode, KeyEvent e) {
        View newIcon;
        View newIcon2;
        View newIcon3;
        View newIcon4;
        ShortcutAndWidgetContainer parent = (ShortcutAndWidgetContainer) v.getParent();
        CellLayout layout = (CellLayout) parent.getParent();
        ScrollView scrollView = (ScrollView) layout.getParent();
        Folder folder = (Folder) scrollView.getParent();
        View title = folder.mFolderName;
        int action = e.getAction();
        boolean handleKeyEvent = action != 1;
        switch (keyCode) {
            case 19:
                if (handleKeyEvent && (newIcon3 = getClosestIconOnLine(layout, parent, v, -1)) != null) {
                    newIcon3.requestFocus();
                }
                return true;
            case 20:
                if (handleKeyEvent) {
                    View newIcon5 = getClosestIconOnLine(layout, parent, v, 1);
                    if (newIcon5 != null) {
                        newIcon5.requestFocus();
                    } else {
                        title.requestFocus();
                    }
                }
                return true;
            case 21:
                if (handleKeyEvent && (newIcon4 = getIconInDirection(layout, parent, v, -1)) != null) {
                    newIcon4.requestFocus();
                }
                return true;
            case 22:
                if (handleKeyEvent) {
                    View newIcon6 = getIconInDirection(layout, parent, v, 1);
                    if (newIcon6 != null) {
                        newIcon6.requestFocus();
                    } else {
                        title.requestFocus();
                    }
                }
                return true;
            case FinalCanbus.CAR_WC2_408_14_L /* 122 */:
                if (handleKeyEvent && (newIcon2 = getIconInDirection(layout, parent, -1, 1)) != null) {
                    newIcon2.requestFocus();
                }
                return true;
            case FinalCanbus.CAR_RZC4_PSA301 /* 123 */:
                if (handleKeyEvent && (newIcon = getIconInDirection(layout, parent, parent.getChildCount(), -1)) != null) {
                    newIcon.requestFocus();
                }
                return true;
            default:
                return false;
        }
    }
}
