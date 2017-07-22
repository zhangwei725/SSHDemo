package com.werner.webapp.service;

import com.werner.webapp.dao.BaseDao;
import com.werner.webapp.domain.Banner;
import com.werner.webapp.domain.Data;
import com.werner.webapp.domain.Relation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/************************************************************************
 *                    .::::.                                            *
 *                  .::::::::.                                          *
 *                 :::::::::::                                          *
 *             ..:::::::::::'                                           *
 *           '::::::::::::'                                             *
 *             .::::::::::                                              *
 *        '::::::::::::::..                                             *
 *             ..::::::::::::.                                          *
 *           ``::::::::::::::::                                         *
 *            ::::``:::::::::'        .:::.                             *
 *           ::::'   ':::::'       .::::::::.                           *
 *         .::::'      ::::     .:::::::'::::.                          *
 *        .:::'       :::::  .:::::::::' ':::::.                        *
 *       .::'        :::::.:::::::::'      ':::::.                      *
 *      .::'         ::::::::::::::'         ``::::.                    *
 *  ...:::           ::::::::::::'              ``::.                   *
 * ```` ':.          ':::::::::'                  ::::..                *
 *                    '.:::::'                    ':'````..             *
 *              ━━━━━━━━━━━━━━━━━━━━━                                   *
 ************************************************************************
 *
 */
@Service("homeService")
public class HomeServiceImpl implements HomeService {
    @Resource()
    BaseDao baseDao;

    @Override
    public void saveData(Data data) {
        baseDao.batchInsertAndUpdate(data.getBanner());
        baseDao.batchInsertAndUpdate(data.getData_type());
        baseDao.batchInsertAndUpdate(data.getRelation_good_four());
    }
}
