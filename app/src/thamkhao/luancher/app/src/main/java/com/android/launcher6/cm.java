package com.android.launcher6;

import android.support.v4.view.MotionEventCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class cm {
    private static View a(CellLayout cellLayout, ViewGroup viewGroup, int i, int i2) {
        return a(a(cellLayout, viewGroup), i, i2);
    }

    private static View a(CellLayout cellLayout, ViewGroup viewGroup, View view, int i) {
        ArrayList arrayListA = a(cellLayout, viewGroup);
        return a(arrayListA, arrayListA.indexOf(view), i);
    }

    private static View a(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        int i3 = i + i2;
        while (i3 >= 0 && i3 < size) {
            View view = (View) arrayList.get(i3);
            if ((view instanceof BubbleTextView) || (view instanceof FolderIcon)) {
                return view;
            }
            i3 += i2;
        }
        return null;
    }

    private static ViewGroup a(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2 = (ViewGroup) ((li) viewGroup).c(i);
        return viewGroup2 instanceof CellLayout ? ((CellLayout) viewGroup2).getShortcutsAndWidgets() : viewGroup2;
    }

    private static TabHost a(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof TabHost)) {
            parent = parent.getParent();
        }
        return (TabHost) parent;
    }

    private static ArrayList a(CellLayout cellLayout, ViewGroup viewGroup) {
        int countX = cellLayout.getCountX();
        int childCount = viewGroup.getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            arrayList.add(viewGroup.getChildAt(i));
        }
        Collections.sort(arrayList, new cn(countX));
        return arrayList;
    }

    static boolean a(View view, int i, KeyEvent keyEvent) {
        TabHost tabHostA = a(view);
        FrameLayout tabContentView = tabHostA.getTabContentView();
        View viewFindViewById = tabHostA.findViewById(R.id.market_button);
        boolean z = keyEvent.getAction() != 1;
        switch (i) {
            case 20:
                if (!z || view != viewFindViewById) {
                    return false;
                }
                tabContentView.requestFocus();
                return true;
            case MotionEventCompat.AXIS_WHEEL /* 21 */:
            default:
                return false;
            case MotionEventCompat.AXIS_GAS /* 22 */:
                if (!z || view == viewFindViewById) {
                    return true;
                }
                viewFindViewById.requestFocus();
                return true;
        }
    }

    static boolean a(View view, int i, KeyEvent keyEvent, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        Workspace workspace = (Workspace) ((ViewGroup) viewGroup.getParent()).findViewById(R.id.workspace);
        int iIndexOfChild = viewGroup.indexOfChild(view);
        int childCount = viewGroup.getChildCount();
        int currentPage = workspace.getCurrentPage();
        boolean z = keyEvent.getAction() != 1;
        switch (i) {
            case 19:
                if (z) {
                    CellLayout cellLayout = (CellLayout) workspace.getChildAt(currentPage);
                    View viewA = a(cellLayout, cellLayout.getShortcutsAndWidgets(), -1, 1);
                    if (viewA != null) {
                        viewA.requestFocus();
                    } else {
                        workspace.requestFocus();
                    }
                }
                return true;
            case 20:
                return true;
            case MotionEventCompat.AXIS_WHEEL /* 21 */:
                if (z) {
                    if (iIndexOfChild > 0) {
                        viewGroup.getChildAt(iIndexOfChild - 1).requestFocus();
                    } else {
                        workspace.n(currentPage - 1);
                    }
                }
                return true;
            case MotionEventCompat.AXIS_GAS /* 22 */:
                if (z) {
                    if (iIndexOfChild < childCount - 1) {
                        viewGroup.getChildAt(iIndexOfChild + 1).requestFocus();
                    } else {
                        workspace.n(currentPage + 1);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    static boolean a(AccessibleTabView accessibleTabView, int i, KeyEvent keyEvent) {
        boolean z;
        if (!ip.a().j()) {
            return false;
        }
        FocusOnlyTabWidget focusOnlyTabWidget = (FocusOnlyTabWidget) accessibleTabView.getParent();
        TabHost tabHostA = a(focusOnlyTabWidget);
        FrameLayout tabContentView = tabHostA.getTabContentView();
        int tabCount = focusOnlyTabWidget.getTabCount();
        int iA = focusOnlyTabWidget.a(accessibleTabView);
        boolean z2 = keyEvent.getAction() != 1;
        switch (i) {
            case 19:
                z = true;
                break;
            case 20:
                if (z2) {
                    tabContentView.requestFocus();
                }
                z = true;
                break;
            case MotionEventCompat.AXIS_WHEEL /* 21 */:
                if (z2 && iA > 0) {
                    focusOnlyTabWidget.getChildTabViewAt(iA - 1).requestFocus();
                }
                z = true;
                break;
            case MotionEventCompat.AXIS_GAS /* 22 */:
                if (z2) {
                    if (iA < tabCount - 1) {
                        focusOnlyTabWidget.getChildTabViewAt(iA + 1).requestFocus();
                    } else if (accessibleTabView.getNextFocusRightId() != -1) {
                        tabHostA.findViewById(accessibleTabView.getNextFocusRightId()).requestFocus();
                    }
                }
                z = true;
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0090  */
    private static View b(CellLayout cellLayout, ViewGroup viewGroup, View view, int i) {
        boolean z;
        ArrayList arrayListA = a(cellLayout, viewGroup);
        al alVar = (al) view.getLayoutParams();
        int countY = cellLayout.getCountY();
        int i2 = alVar.b;
        int i3 = i2 + i;
        if (i3 >= 0 && i3 < countY) {
            int i4 = -1;
            int iIndexOf = arrayListA.indexOf(view);
            int size = i < 0 ? -1 : arrayListA.size();
            float f = Float.MAX_VALUE;
            while (iIndexOf != size) {
                View view2 = (View) arrayListA.get(iIndexOf);
                al alVar2 = (al) view2.getLayoutParams();
                if (i < 0) {
                    z = alVar2.b < i2;
                } else {
                    z = alVar2.b > i2;
                }
                if (z && ((view2 instanceof BubbleTextView) || (view2 instanceof FolderIcon))) {
                    float fSqrt = (float) Math.sqrt(Math.pow(alVar2.f109a - alVar.f109a, 2.0d) + Math.pow(alVar2.b - alVar.b, 2.0d));
                    if (fSqrt < f) {
                        f = fSqrt;
                        i4 = iIndexOf;
                    } else {
                        i4 = i4;
                        f = f;
                    }
                } else {
                    i4 = i4;
                    f = f;
                }
                iIndexOf = iIndexOf <= size ? iIndexOf + 1 : iIndexOf - 1;
            }
            if (i4 > -1) {
                return (View) arrayListA.get(i4);
            }
        }
        return null;
    }

    private static mo b(ViewGroup viewGroup, int i) {
        return (mo) ((ViewGroup) viewGroup.getChildAt(i)).getChildAt(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean b(View view, int i, KeyEvent keyEvent) {
        int cellCountX;
        int cellCountY;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroupA;
        ViewGroup viewGroupA2;
        if (view.getParent() instanceof mo) {
            ViewGroup viewGroup3 = (ViewGroup) view.getParent();
            ViewGroup viewGroup4 = (ViewGroup) viewGroup3.getParent();
            int countX = ((CellLayout) viewGroup4).getCountX();
            viewGroup2 = viewGroup4;
            cellCountY = ((CellLayout) viewGroup4).getCountY();
            cellCountX = countX;
            viewGroup = viewGroup3;
        } else {
            ViewGroup viewGroup5 = (ViewGroup) view.getParent();
            cellCountX = ((lw) viewGroup5).getCellCountX();
            cellCountY = ((lw) viewGroup5).getCellCountY();
            viewGroup = viewGroup5;
            viewGroup2 = viewGroup5;
        }
        li liVar = (li) viewGroup2.getParent();
        TabWidget tabWidget = a(liVar).getTabWidget();
        int iIndexOfChild = viewGroup.indexOfChild(view);
        int childCount = viewGroup.getChildCount();
        int iD = liVar.d(liVar.indexOfChild(viewGroup2));
        int childCount2 = liVar.getChildCount();
        int i2 = iIndexOfChild % cellCountX;
        int i3 = iIndexOfChild / cellCountX;
        boolean z = keyEvent.getAction() != 1;
        switch (i) {
            case 19:
                if (z) {
                    if (i3 > 0) {
                        viewGroup.getChildAt(((i3 - 1) * cellCountX) + i2).requestFocus();
                    } else {
                        tabWidget.requestFocus();
                    }
                }
                return true;
            case 20:
                if (z && i3 < cellCountY - 1) {
                    viewGroup.getChildAt(Math.min(childCount - 1, ((i3 + 1) * cellCountX) + i2)).requestFocus();
                }
                return true;
            case MotionEventCompat.AXIS_WHEEL /* 21 */:
                if (z) {
                    if (iIndexOfChild > 0) {
                        viewGroup.getChildAt(iIndexOfChild - 1).requestFocus();
                    } else if (iD > 0 && (viewGroupA2 = a(liVar, iD - 1)) != null) {
                        liVar.n(iD - 1);
                        View childAt = viewGroupA2.getChildAt(viewGroupA2.getChildCount() - 1);
                        if (childAt != null) {
                            childAt.requestFocus();
                        }
                    }
                }
                return true;
            case MotionEventCompat.AXIS_GAS /* 22 */:
                if (z) {
                    if (iIndexOfChild < childCount - 1) {
                        viewGroup.getChildAt(iIndexOfChild + 1).requestFocus();
                    } else if (iD < childCount2 - 1 && (viewGroupA = a(liVar, iD + 1)) != null) {
                        liVar.n(iD + 1);
                        View childAt2 = viewGroupA.getChildAt(0);
                        if (childAt2 != null) {
                            childAt2.requestFocus();
                        }
                    }
                }
                return true;
            case MotionEventCompat.AXIS_BRAKE /* 23 */:
            case 66:
                if (z) {
                    ((View.OnClickListener) liVar).onClick(view);
                }
                return true;
            case 92:
                if (z) {
                    if (iD > 0) {
                        ViewGroup viewGroupA3 = a(liVar, iD - 1);
                        if (viewGroupA3 != null) {
                            liVar.n(iD - 1);
                            View childAt3 = viewGroupA3.getChildAt(0);
                            if (childAt3 != null) {
                                childAt3.requestFocus();
                            }
                        }
                    } else {
                        viewGroup.getChildAt(0).requestFocus();
                    }
                }
                return true;
            case 93:
                if (z) {
                    if (iD < childCount2 - 1) {
                        ViewGroup viewGroupA4 = a(liVar, iD + 1);
                        if (viewGroupA4 != null) {
                            liVar.n(iD + 1);
                            View childAt4 = viewGroupA4.getChildAt(0);
                            if (childAt4 != null) {
                                childAt4.requestFocus();
                            }
                        }
                    } else {
                        viewGroup.getChildAt(childCount - 1).requestFocus();
                    }
                }
                return true;
            case 122:
                if (z) {
                    viewGroup.getChildAt(0).requestFocus();
                }
                return true;
            case 123:
                if (z) {
                    viewGroup.getChildAt(childCount - 1).requestFocus();
                }
                return true;
            default:
                return false;
        }
    }

    static boolean c(View view, int i, KeyEvent keyEvent) {
        View viewA;
        View viewA2;
        mo moVar = (mo) view.getParent();
        CellLayout cellLayout = (CellLayout) moVar.getParent();
        Workspace workspace = (Workspace) cellLayout.getParent();
        ViewGroup viewGroup = (ViewGroup) workspace.getParent();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.qsb_bar);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.hotseat);
        int iIndexOfChild = workspace.indexOfChild(cellLayout);
        int childCount = workspace.getChildCount();
        boolean z = keyEvent.getAction() != 1;
        switch (i) {
            case 19:
                if (!z) {
                    return false;
                }
                View viewB = b(cellLayout, moVar, view, -1);
                if (viewB != null) {
                    viewB.requestFocus();
                    return true;
                }
                viewGroup2.requestFocus();
                return false;
            case 20:
                if (!z) {
                    return false;
                }
                View viewB2 = b(cellLayout, moVar, view, 1);
                if (viewB2 != null) {
                    viewB2.requestFocus();
                    return true;
                }
                if (viewGroup3 == null) {
                    return false;
                }
                viewGroup3.requestFocus();
                return false;
            case MotionEventCompat.AXIS_WHEEL /* 21 */:
                if (z) {
                    View viewA3 = a(cellLayout, moVar, view, -1);
                    if (viewA3 != null) {
                        viewA3.requestFocus();
                    } else if (iIndexOfChild > 0) {
                        mo moVarB = b(workspace, iIndexOfChild - 1);
                        View viewA4 = a(cellLayout, moVarB, moVarB.getChildCount(), -1);
                        if (viewA4 != null) {
                            viewA4.requestFocus();
                        } else {
                            workspace.n(iIndexOfChild - 1);
                        }
                    }
                }
                return true;
            case MotionEventCompat.AXIS_GAS /* 22 */:
                if (z) {
                    View viewA5 = a(cellLayout, moVar, view, 1);
                    if (viewA5 != null) {
                        viewA5.requestFocus();
                    } else if (iIndexOfChild < childCount - 1) {
                        View viewA6 = a(cellLayout, b(workspace, iIndexOfChild + 1), -1, 1);
                        if (viewA6 != null) {
                            viewA6.requestFocus();
                        } else {
                            workspace.n(iIndexOfChild + 1);
                        }
                    }
                }
                return true;
            case 92:
                if (z) {
                    if (iIndexOfChild > 0) {
                        View viewA7 = a(cellLayout, b(workspace, iIndexOfChild - 1), -1, 1);
                        if (viewA7 != null) {
                            viewA7.requestFocus();
                        } else {
                            workspace.n(iIndexOfChild - 1);
                        }
                    } else {
                        View viewA8 = a(cellLayout, moVar, -1, 1);
                        if (viewA8 != null) {
                            viewA8.requestFocus();
                        }
                    }
                }
                return true;
            case 93:
                if (z) {
                    if (iIndexOfChild < childCount - 1) {
                        View viewA9 = a(cellLayout, b(workspace, iIndexOfChild + 1), -1, 1);
                        if (viewA9 != null) {
                            viewA9.requestFocus();
                        } else {
                            workspace.n(iIndexOfChild + 1);
                        }
                    } else {
                        View viewA10 = a(cellLayout, moVar, moVar.getChildCount(), -1);
                        if (viewA10 != null) {
                            viewA10.requestFocus();
                        }
                    }
                }
                return true;
            case 122:
                if (z && (viewA2 = a(cellLayout, moVar, -1, 1)) != null) {
                    viewA2.requestFocus();
                }
                return true;
            case 123:
                if (z && (viewA = a(cellLayout, moVar, moVar.getChildCount(), -1)) != null) {
                    viewA.requestFocus();
                }
                return true;
            default:
                return false;
        }
    }

    static boolean d(View view, int i, KeyEvent keyEvent) {
        View viewA;
        View viewA2;
        View viewB;
        View viewA3;
        mo moVar = (mo) view.getParent();
        CellLayout cellLayout = (CellLayout) moVar.getParent();
        FolderEditText folderEditText = ((Folder) ((ScrollView) cellLayout.getParent()).getParent()).g;
        boolean z = keyEvent.getAction() != 1;
        switch (i) {
            case 19:
                if (z && (viewB = b(cellLayout, moVar, view, -1)) != null) {
                    viewB.requestFocus();
                }
                return true;
            case 20:
                if (z) {
                    View viewB2 = b(cellLayout, moVar, view, 1);
                    if (viewB2 != null) {
                        viewB2.requestFocus();
                    } else {
                        folderEditText.requestFocus();
                    }
                }
                return true;
            case MotionEventCompat.AXIS_WHEEL /* 21 */:
                if (z && (viewA3 = a(cellLayout, moVar, view, -1)) != null) {
                    viewA3.requestFocus();
                }
                return true;
            case MotionEventCompat.AXIS_GAS /* 22 */:
                if (z) {
                    View viewA4 = a(cellLayout, moVar, view, 1);
                    if (viewA4 != null) {
                        viewA4.requestFocus();
                    } else {
                        folderEditText.requestFocus();
                    }
                }
                return true;
            case 122:
                if (z && (viewA2 = a(cellLayout, moVar, -1, 1)) != null) {
                    viewA2.requestFocus();
                }
                return true;
            case 123:
                if (z && (viewA = a(cellLayout, moVar, moVar.getChildCount(), -1)) != null) {
                    viewA.requestFocus();
                }
                return true;
            default:
                return false;
        }
    }
}
