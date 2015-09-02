package Cache;

import com.google.common.cache.CacheBuilder;

import java.util.Map;

/**
 * Created by previousdeveloper on 2.09.2015.
 */
public class CacheStore {

    public static <K, V> Map<K, V> makeMap(final int maxSize) {
        return CacheBuilder.newBuilder()
                .maximumSize(maxSize)
                .<K, V>build() // not using a cache loader
                .asMap();
    }
}
