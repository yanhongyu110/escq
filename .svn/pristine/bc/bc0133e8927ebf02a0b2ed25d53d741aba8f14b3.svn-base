package com.jero.esc.common.scheduler;

import com.jero.esc.common.utils.baidumap.BaiduCouldSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    BaiduCouldSave baiduCouldSave;

    @Scheduled(cron = "0 0 0 4 * ? ")
//    @Scheduled(fixedRate = 1000)
    public void go() throws Exception {
        baiduCouldSave.sync();
    }


}
