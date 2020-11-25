package com.techsharezone.bootifyspringsecurityotp.service;

/*
 * @created 24/11/2020 -23:44
 * @project bootify-spring-security-otp
 * @author  saurabhshcs
 */


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class BootifyOTPService {

    private static final Logger LOG = LoggerFactory.getLogger(BootifyOTPService.class);
    private static final String LOGGING_PREFIX = "BootifyOTPService: ";

    private static Integer EXPIRE_MINS = 5;

//    private LoadingCache<String, Integer> otpCache;
//
//    public BootifyOTPService(LoadingCache<String, Integer> otpCache) {
//        otpCache = CacheBuilder
//                .newBuilder()
//                .expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
//                .build(new CacheLoader<String, Integer>() {
//                    @Override
//                    public Integer load(String key) throws Exception {
//                        return 0;
//                    }
//                });
//    }

    /*
     * This method is used to push the opt number against Key. Rewrite the OTP if it exists
     * Using user id  as key
     * */
    public Integer generateOtp(final String key) {
        Random random = new Random();
        Integer otp = 100000 + random.nextInt(900000);
//        otpCache.put(key, otp);

        LOG.info(LOGGING_PREFIX + "OTP [{}] is generated for user(key) [{}]", otp, key);
        return otp;
    }
//
//    public Integer getOtp(final String key) {
//        try {
//            Integer otp = otpCache.get(key);
//            LOG.info(LOGGING_PREFIX + "OTP [{}] is received for user(key) [{}]", otp, key);
//
//            return otp;
//        } catch (ExecutionException e) {
//            LOG.error(LOGGING_PREFIX + " here is an exception caught as {}", e.getMessage());
//        }
//        return 0;
//    }
//
//    public void clearOtp(final String key) {
//
//        LOG.info(LOGGING_PREFIX + "OTP is invalidated for user(key) [{}]", key);
//        otpCache.invalidate(key);
//    }
}
