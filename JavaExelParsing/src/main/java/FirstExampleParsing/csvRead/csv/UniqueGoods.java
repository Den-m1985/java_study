package FirstExampleParsing.csvRead.csv;

import java.util.*;

public class UniqueGoods {
    private List<StructureCSV> duplicateNames;


    public UniqueGoods() {
    }


    public List<StructureCSV> uniqueGoods(List<StructureCSV> dataWithItem) {

        List<StructureCSV> uniqueValues = new ArrayList<>();
        duplicateNames = new ArrayList<>();

        /*
        Для того, чтобы имена не меняли порядок, можно использовать LinkedHashMap
        для подсчета количества повторений имен. LinkedHashMap сохраняет порядок
         элементов в том порядке, в котором они были добавлены в мапу,
         в отличие от обычного HashMap.
         В первом цикле мы используем LinkedHashMap `nameCounts` для подсчета
         количества повторений имен и сохраняем порядок элементов.
         Во втором цикле мы добавляем элементы в соответствующие списки
         в зависимости от количества повторений имени в мапе `nameCounts`.
         */
        Map<String, Integer> nameCounts = new LinkedHashMap<>();

        for (StructureCSV structureCSV : dataWithItem) {
            String name = structureCSV.getName();
            int count = nameCounts.getOrDefault(name, 0) + 1;
            //System.out.println(count + "---" + name);
            nameCounts.put(name, count);
        }

        for (StructureCSV structureCSV : dataWithItem) {
            String name = structureCSV.getName();
            if (nameCounts.get(name) == 1) {
                uniqueValues.add(structureCSV);
            } else {
                duplicateNames.add(structureCSV);
            }
        }
        duplicateNames.sort(Comparator.comparing(StructureCSV::getName));

//        int i = 0;
//        for (StructureCSV row : dataWithItem) {
//            String name = row.getName();
//            for (StructureCSV value : dataWithItem) {
//                String name2 = value.getName();
//                if (name.equals(name2)) {
//                    i++;
//                    if (i > 1) {
//                        duplicateNames.add(row);
//                        break;
//                    }
//                }
//            }
//            if (i == 1) {
//                uniqueValues.add(row);
//            }
//            i = 0;
//        }
        return uniqueValues;
    }


    public List<StructureCSV> getDuplicateNames() {
        return duplicateNames;
    }
}
