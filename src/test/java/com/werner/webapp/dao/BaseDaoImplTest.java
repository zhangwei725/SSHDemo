package com.werner.webapp.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
public class BaseDaoImplTest {
    @Autowired
    BaseDao<Category> dao;

    @Test
    public void findAll() throws Exception {
        dao.findAll(1, 20);

    }

    @Test
    public void save() throws Exception {
        Category category = new Category();
        category.setType("测试");
        dao.save(category);

    }
}
