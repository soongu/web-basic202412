package com.jsp.basic.chap02;

import java.util.ArrayList;
import java.util.List;

// 댄서들 여러명의 목록을 관리
public class DancerList {

    private static List<Dancer> dancerList = new ArrayList<>();

    // 댄서 목록을 갖다주는 기능
    public static List<Dancer> getDancerList() {
        return dancerList;
    }
    // 댄서 목록에 댄서를 추가하는 기능
    public static void addDancer(Dancer dancer) {
        dancerList.add(dancer);
    }
}
