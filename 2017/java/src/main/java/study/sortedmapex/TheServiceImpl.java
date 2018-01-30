package study.sortedmapex;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TheServiceImpl implements TheService {

    Map<String, Integer> views;
    Map<Integer, List<String>> rankingMap;

    public TheServiceImpl() {
        views = new HashMap<>();
        rankingMap = new TreeMap<>(Collections.reverseOrder());
    }

    @Override
    public void view(String id) {
        Integer view = views.get(id);

        if (view != null) {
            rankingMap.compute(view, (integer, strings) -> {
                if (strings != null) {
                    strings.remove(id);
                }

                return strings;
            });
        }

        view = views.compute(id, (s, integer) -> integer != null ? integer + 1 : 1);

        rankingMap.compute(view, (integer, strings) -> {
            List<String> ids;

            if (strings == null) {
                ids = new LinkedList<>();
            } else {
                ids = new LinkedList<>(strings);
            }

            ids.add(id);

            return ids;
        });
    }

    @Override
    public int order(String id) {
        Integer view = views.get(id);
        int ranking = 0;

        if (view != null) {
            for (Map.Entry<Integer, List<String>> entry : rankingMap.entrySet()) {
                boolean found = false;
                for (String viewed : entry.getValue()) {
                    if (!viewed.equals(id)) {
                        ranking++;
                    } else {
                        ranking++;
                        found = true;
                        break;
                    }
                }

                if (found) {
                    break;
                }
            }
        }

        return ranking > 0 ? ranking : -1;
    }

    @Override
    public List<String> top10() {
        return rankingMap.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .limit(10)
                .collect(Collectors.toList());
    }
}
