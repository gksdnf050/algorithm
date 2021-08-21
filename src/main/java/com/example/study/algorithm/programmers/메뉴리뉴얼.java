package com.example.study.algorithm.programmers;

import java.util.*;
class 메뉴리뉴얼 {
    String[] menu;
    String[] output;
    List<MenuCombi> menuCombis;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList();
        Set<String> set = new LinkedHashSet();

        for(String str : orders) {
            for(int i = 0; i < str.length(); i ++) {
                set.add(str.charAt(i)+"");
            }
        }

        List<String> list = new ArrayList(set);
        menu = new String[list.size()];
        Collections.sort(list);
        for(int i = 0; i < list.size(); i ++) {
            menu[i] = list.get(i);
        }
        for(int i = 0; i < course.length; i++) {
            output = new String[course[i]];
            menuCombis = new ArrayList();
            combi(course[i], 0, orders, 0);
            Collections.sort(menuCombis, new Comparator<MenuCombi>() {

                public int compare(MenuCombi m1, MenuCombi m2) {
                    return m2.count - m1.count;
                }
            });

            if(menuCombis.size() > 0) {
                int max = menuCombis.get(0).count;
                for(MenuCombi m : menuCombis) {
                    if(max ==  m.count)
                        answer.add(m.str);
                }

            }
        }
        Collections.sort(answer);
        String[] ans = answer.toArray(new String[answer.size()]);

        return ans;
    }

    public void combi(int end, int depth, String[] orders, int j) {
        if(end == depth) {

            solve(orders);

            return;
        }

        for(int i= j; i < menu.length; i ++) {

            output[depth] = menu[i];

            combi(end, depth + 1, orders, i + 1);

        }
    }

    public void solve(String[] orders) {
        int count = 0;

        for(String str : orders) {
            boolean b = true;
            for(String out : output) {
                if(str.contains(out) == false) {
                    b = false;
                    break;
                }
            }

            if(b == true) count++;
        }

        if(count >= 2) {
            String temp = "";
            for(String out : output) {
                temp += out;
            }
            menuCombis.add(new MenuCombi(temp, count));
        }
    }
}

class MenuCombi {
    public String str;
    public int count;

    MenuCombi(String str, int count) {
        this.str = str;
        this.count = count;
    }
}
