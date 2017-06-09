package musicboox.service;

import static javax.cache.expiry.Duration.ONE_HOUR;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.spi.CachingProvider;

public class StringCacheManager {

  private static final StringCacheManager INSTANCE = new StringCacheManager();
  private static final Cache<String, String> CACHE;
  
  static {
    //resolve a cache manager
    CachingProvider cachingProvider = Caching.getCachingProvider();
    CacheManager cacheManager = cachingProvider.getCacheManager();

    //configure the cache
    MutableConfiguration<String, String> config = new MutableConfiguration<String, String>()
        .setTypes(String.class, String.class)
        .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(ONE_HOUR))
        .setStatisticsEnabled(true);

    //create the cache
    CACHE = cacheManager.createCache("simpleCache", config);
  }

  private StringCacheManager() {
  }

  public static StringCacheManager getInstance() {
    return INSTANCE;
  }

  public String getAndRemove(String key) {
    return CACHE.getAndRemove(key);
  }

  public void put(String key, String value) {
    CACHE.put(key, value);
  }

  public void remove(String key) {
    CACHE.remove(key);
  }

  public boolean containsKey(String key) {
    return CACHE.containsKey(key);
  }
}
