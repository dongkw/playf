package common.util;


import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by dkw on 2017/6/29.
 */
public class CollectionUtil {

    private CollectionUtil(){

    }
    /**
     * 判断connection是否为空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    /**
     * 判断connection是否为非空
     *
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }


}
