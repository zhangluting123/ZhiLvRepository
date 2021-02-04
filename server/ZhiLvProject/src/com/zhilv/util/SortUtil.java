package com.zhilv.util;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**   
 * @ClassName: SortUtil   
 * @Description:TODO
 * @author: �����
 * @date: 2021��1��26�� ����10:17:35       
 */
public class SortUtil {
	private final static String SORT_ASC = "ASC";
    private final static String SORT_DESC = "DESC";

    /**
     * ��������
     * @param list ������ļ���
     * @param property Ԫ������
     * @param sort ����ʽ
     * @param <T>
     * @return
     */
    public static <T> void sortList(List<T> list, String property, String sort) {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                try {
                    Field field1 = o1.getClass().getDeclaredField(property);
                    field1.setAccessible(true);
                    Long long1 = ((Date)field1.get(o1)).getTime();

                    Field field2 = o2.getClass().getDeclaredField(property);
                    field2.setAccessible(true);
                    Long long2 = ((Date)field2.get(o2)).getTime();

                    //����
                    if (sort.toUpperCase().equals(SORT_DESC))
                        return long2.compareTo(long1);

                    //����
                    if (sort.toUpperCase().equals(SORT_ASC))
                        return long1.compareTo(long2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }
    
    
}
