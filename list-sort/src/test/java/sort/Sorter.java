package sort;

import java.util.Arrays;
import java.util.List;

public class Sorter {

    public List<Integer> sort(List<Integer> listToOrder) {
        if(listToOrder.size()>1){
            for(int j=0;j<listToOrder.size();j++){
                Integer pivot = 0;
                for(int i=1; i< listToOrder.size()-j; i++){
                    if(listToOrder.get(pivot) > listToOrder.get(i)){
                        swap(pivot, i,listToOrder);
                    }
                    pivot = i;
                }
            }
        }
        return listToOrder;
    }

    private void swap(Integer pivot, int i, List<Integer> listToOrder) {
        Integer temp = listToOrder.get(i);
        listToOrder.set(i,listToOrder.get(pivot));
        listToOrder.set(pivot,temp);
    }


}