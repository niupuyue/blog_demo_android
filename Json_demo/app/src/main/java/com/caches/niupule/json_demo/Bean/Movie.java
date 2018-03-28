package com.caches.niupule.json_demo.Bean;

import java.util.List;

/**
 * Created: niupule
 * Date: 2018/3/28  上午11:53
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class Movie {

    //https://api.douban.com/v2/movie/in_theaters

    /**
     * count : 20
     * start : 0
     * total : 28
     * subjects : [{"rating":{"max":10,"average":5.8,"stars":"30","min":0},"genres":["动作","科幻","冒险"],"title":"环太平洋：雷霆再起","casts":[{"alt":"https://movie.douban.com/celebrity/1339915/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp"},"name":"约翰·博耶加","id":"1339915"},{"alt":"https://movie.douban.com/celebrity/1000188/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1418720473.76.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1418720473.76.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1418720473.76.webp"},"name":"斯科特·伊斯特伍德","id":"1000188"},{"alt":"https://movie.douban.com/celebrity/1362560/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1479205212.79.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1479205212.79.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1479205212.79.webp"},"name":"卡莉·史派妮","id":"1362560"}],"collect_count":62199,"original_title":"Pacific Rim: Uprising","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1340823/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp"},"name":"斯蒂文·S·迪奈特","id":"1340823"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512933684.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512933684.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512933684.webp"},"alt":"https://movie.douban.com/subject/20435622/","id":"20435622"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["剧情","喜剧","爱情"],"title":"遇见你真好","casts":[{"alt":"https://movie.douban.com/celebrity/1332932/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pmk5M2yEclAMcel_avatar_uploaded1376453132.87.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pmk5M2yEclAMcel_avatar_uploaded1376453132.87.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pmk5M2yEclAMcel_avatar_uploaded1376453132.87.webp"},"name":"白客","id":"1332932"},{"alt":"https://movie.douban.com/celebrity/1318954/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45514.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45514.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p45514.webp"},"name":"蓝盈莹","id":"1318954"},{"alt":"https://movie.douban.com/celebrity/1364842/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1481737131.45.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1481737131.45.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1481737131.45.webp"},"name":"张海宇","id":"1364842"}],"collect_count":465,"original_title":"遇见你真好","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1037747/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1423.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1423.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1423.webp"},"name":"顾长卫","id":"1037747"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516082047.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516082047.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516082047.webp"},"alt":"https://movie.douban.com/subject/26967920/","id":"26967920"},{"rating":{"max":10,"average":6.4,"stars":"35","min":0},"genres":["动作","冒险"],"title":"古墓丽影：源起之战","casts":[{"alt":"https://movie.douban.com/celebrity/1233154/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1427204716.36.webp"},"name":"艾丽西亚·维坎德","id":"1233154"},{"alt":"https://movie.douban.com/celebrity/1027173/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4228.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4228.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4228.webp"},"name":"多米尼克·威斯特","id":"1027173"},{"alt":"https://movie.douban.com/celebrity/1098551/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50351.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50351.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50351.webp"},"name":"沃尔顿·戈金斯","id":"1098551"}],"collect_count":46463,"original_title":"Tomb Raider","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1051062/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492880241.68.webp"},"name":"罗阿尔·乌索格","id":"1051062"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2512717509.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2512717509.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2512717509.webp"},"alt":"https://movie.douban.com/subject/3445906/","id":"3445906"},{"rating":{"max":10,"average":8.5,"stars":"45","min":0},"genres":["剧情","动作","犯罪"],"title":"红海行动","casts":[{"alt":"https://movie.douban.com/celebrity/1274761/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489386626.47.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489386626.47.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489386626.47.webp"},"name":"张译","id":"1274761"},{"alt":"https://movie.douban.com/celebrity/1354442/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1458138265.51.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1458138265.51.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1458138265.51.webp"},"name":"黄景瑜","id":"1354442"},{"alt":"https://movie.douban.com/celebrity/1272245/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p49399.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p49399.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p49399.webp"},"name":"海清","id":"1272245"}],"collect_count":352946,"original_title":"红海行动","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1275075/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1372934445.18.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1372934445.18.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1372934445.18.webp"},"name":"林超贤","id":"1275075"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514119443.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514119443.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514119443.webp"},"alt":"https://movie.douban.com/subject/26861685/","id":"26861685"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["纪录片"],"title":"厉害了，我的国","casts":[],"collect_count":124,"original_title":"厉害了，我的国","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1322050/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52221.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52221.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52221.webp"},"name":"卫铁","id":"1322050"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514293556.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514293556.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514293556.webp"},"alt":"https://movie.douban.com/subject/30152451/","id":"30152451"},{"rating":{"max":10,"average":6.7,"stars":"35","min":0},"genres":["动作","科幻","冒险"],"title":"黑豹","casts":[{"alt":"https://movie.douban.com/celebrity/1327680/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518765586.91.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518765586.91.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518765586.91.webp"},"name":"查德维克·博斯曼","id":"1327680"},{"alt":"https://movie.douban.com/celebrity/1334862/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1385433474.91.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1385433474.91.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1385433474.91.webp"},"name":"露皮塔·尼永奥","id":"1334862"},{"alt":"https://movie.douban.com/celebrity/1107320/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1473330747.67.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1473330747.67.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1473330747.67.webp"},"name":"迈克尔·B·乔丹","id":"1107320"}],"collect_count":131425,"original_title":"Black Panther","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1326531/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pPjZDSsF679kcel_avatar_uploaded1359524956.71.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pPjZDSsF679kcel_avatar_uploaded1359524956.71.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pPjZDSsF679kcel_avatar_uploaded1359524956.71.webp"},"name":"瑞恩·库格勒","id":"1326531"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512123434.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512123434.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512123434.webp"},"alt":"https://movie.douban.com/subject/6390825/","id":"6390825"},{"rating":{"max":10,"average":7.3,"stars":"40","min":0},"genres":["剧情","爱情","奇幻"],"title":"水形物语","casts":[{"alt":"https://movie.douban.com/celebrity/1044915/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48056.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48056.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48056.webp"},"name":"莎莉·霍金斯","id":"1044915"},{"alt":"https://movie.douban.com/celebrity/1019031/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p18795.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p18795.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p18795.webp"},"name":"道格·琼斯","id":"1019031"},{"alt":"https://movie.douban.com/celebrity/1144415/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p57057.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p57057.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p57057.webp"},"name":"迈克尔·珊农","id":"1144415"}],"collect_count":180131,"original_title":"The Shape of Water","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1027182/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4294.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4294.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4294.webp"},"name":"吉尔莫·德尔·托罗","id":"1027182"}],"year":"2017","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2515650989.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2515650989.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2515650989.webp"},"alt":"https://movie.douban.com/subject/26752852/","id":"26752852"},{"rating":{"max":10,"average":8.6,"stars":"45","min":0},"genres":["剧情","喜剧","动作"],"title":"小萝莉的猴神大叔","casts":[{"alt":"https://movie.douban.com/celebrity/1017831/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1355291691.29.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1355291691.29.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1355291691.29.webp"},"name":"萨尔曼·汗","id":"1017831"},{"alt":"https://movie.douban.com/celebrity/1350825/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1448788341.64.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1448788341.64.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1448788341.64.webp"},"name":"哈莎莉·马洛特拉","id":"1350825"},{"alt":"https://movie.douban.com/celebrity/1049635/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5568.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5568.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5568.webp"},"name":"卡琳娜·卡普尔","id":"1049635"}],"collect_count":140566,"original_title":"Bajrangi Bhaijaan","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1304615/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p57344.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p57344.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p57344.webp"},"name":"卡比尔·汗","id":"1304615"}],"year":"2015","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2510956726.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2510956726.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2510956726.webp"},"alt":"https://movie.douban.com/subject/26393561/","id":"26393561"},{"rating":{"max":10,"average":7.4,"stars":"40","min":0},"genres":["喜剧","动画","冒险"],"title":"比得兔","casts":[{"alt":"https://movie.douban.com/celebrity/1017966/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1449532609.88.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1449532609.88.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1449532609.88.webp"},"name":"詹姆斯·柯登","id":"1017966"},{"alt":"https://movie.douban.com/celebrity/1313116/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1361026097.22.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1361026097.22.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1361026097.22.webp"},"name":"多姆纳尔·格里森","id":"1313116"},{"alt":"https://movie.douban.com/celebrity/1022562/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3186.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3186.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p3186.webp"},"name":"萝丝·拜恩","id":"1022562"}],"collect_count":23377,"original_title":"Peter Rabbit","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274281/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p12038.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p12038.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p12038.webp"},"name":"威尔·古勒","id":"1274281"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515434674.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515434674.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515434674.webp"},"alt":"https://movie.douban.com/subject/26649604/","id":"26649604"},{"rating":{"max":10,"average":8.7,"stars":"45","min":0},"genres":["剧情","犯罪"],"title":"三块广告牌","casts":[{"alt":"https://movie.douban.com/celebrity/1010548/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1436865941.42.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1436865941.42.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1436865941.42.webp"},"name":"弗兰西斯·麦克多蒙德","id":"1010548"},{"alt":"https://movie.douban.com/celebrity/1053560/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p501.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p501.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p501.webp"},"name":"伍迪·哈里森","id":"1053560"},{"alt":"https://movie.douban.com/celebrity/1047972/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1358812490.58.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1358812490.58.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1358812490.58.webp"},"name":"山姆·洛克威尔","id":"1047972"}],"collect_count":239855,"original_title":"Three Billboards Outside Ebbing, Missouri","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1000304/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1406649730.61.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1406649730.61.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1406649730.61.webp"},"name":"马丁·麦克唐纳","id":"1000304"}],"year":"2017","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2510081688.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2510081688.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2510081688.webp"},"alt":"https://movie.douban.com/subject/26611804/","id":"26611804"},{"rating":{"max":10,"average":5.8,"stars":"30","min":0},"genres":["喜剧","冒险","家庭"],"title":"萌犬好声音","casts":[{"alt":"https://movie.douban.com/celebrity/1326635/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pW9hxsnIJhQ4cel_avatar_uploaded1359787172.67.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pW9hxsnIJhQ4cel_avatar_uploaded1359787172.67.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pW9hxsnIJhQ4cel_avatar_uploaded1359787172.67.webp"},"name":"麦肯泽·摩斯","id":"1326635"},{"alt":"https://movie.douban.com/celebrity/1268703/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10746.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10746.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p10746.webp"},"name":"凯特林·马希尔","id":"1268703"},{"alt":"https://movie.douban.com/celebrity/1148334/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p55049.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p55049.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p55049.webp"},"name":"杰德·瑞斯","id":"1148334"}],"collect_count":464,"original_title":"Pup Star","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1300097/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1414661698.13.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1414661698.13.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1414661698.13.webp"},"name":"罗伯特·文斯","id":"1300097"}],"year":"2016","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512417830.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512417830.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512417830.webp"},"alt":"https://movie.douban.com/subject/26846031/","id":"26846031"},{"rating":{"max":10,"average":7,"stars":"35","min":0},"genres":["喜剧","动作","犯罪"],"title":"唐人街探案2","casts":[{"alt":"https://movie.douban.com/celebrity/1274388/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1356403251.95.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1356403251.95.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1356403251.95.webp"},"name":"王宝强","id":"1274388"},{"alt":"https://movie.douban.com/celebrity/1336305/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1473508881.63.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1473508881.63.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1473508881.63.webp"},"name":"刘昊然","id":"1336305"},{"alt":"https://movie.douban.com/celebrity/1274979/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518431956.11.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518431956.11.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518431956.11.webp"},"name":"肖央","id":"1274979"}],"collect_count":303925,"original_title":"唐人街探案2","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274763/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469073193.92.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469073193.92.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469073193.92.webp"},"name":"陈思诚","id":"1274763"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2511355624.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2511355624.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2511355624.webp"},"alt":"https://movie.douban.com/subject/26698897/","id":"26698897"},{"rating":{"max":10,"average":5.7,"stars":"30","min":0},"genres":["剧情","喜剧","奇幻"],"title":"脱皮爸爸","casts":[{"alt":"https://movie.douban.com/celebrity/1037098/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48479.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48479.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48479.webp"},"name":"吴镇宇","id":"1037098"},{"alt":"https://movie.douban.com/celebrity/1027577/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1421047436.79.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1421047436.79.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1421047436.79.webp"},"name":"古天乐","id":"1027577"},{"alt":"https://movie.douban.com/celebrity/1339442/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464723431.73.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464723431.73.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464723431.73.webp"},"name":"春夏","id":"1339442"}],"collect_count":1349,"original_title":"脱皮爸爸","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1298762/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44898.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44898.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44898.webp"},"name":"司徒慧焯","id":"1298762"}],"year":"2016","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516154772.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516154772.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516154772.webp"},"alt":"https://movie.douban.com/subject/26661194/","id":"26661194"},{"rating":{"max":10,"average":8.2,"stars":"40","min":0},"genres":["喜剧","动画","冒险"],"title":"大坏狐狸的故事","casts":[{"alt":"https://movie.douban.com/celebrity/1385549/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512709389.68.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512709389.68.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512709389.68.webp"},"name":"纪尧姆·达尔诺","id":"1385549"},{"alt":"https://movie.douban.com/celebrity/1385552/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512709841.36.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512709841.36.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512709841.36.webp"},"name":"席琳·荣特","id":"1385552"},{"alt":"https://movie.douban.com/celebrity/1385555/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512710135.63.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512710135.63.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512710135.63.webp"},"name":"达米安·维特卡","id":"1385555"}],"collect_count":15907,"original_title":"Le Grand Méchant Renard et autres contes...","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1327904/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512439428.52.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512439428.52.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512439428.52.webp"},"name":"本杰明·雷内","id":"1327904"},{"alt":"https://movie.douban.com/celebrity/1385323/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512436051.38.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512436051.38.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1512436051.38.webp"},"name":"帕特里克·英伯特","id":"1385323"}],"year":"2017","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515632084.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515632084.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515632084.webp"},"alt":"https://movie.douban.com/subject/27042405/","id":"27042405"},{"rating":{"max":10,"average":7.5,"stars":"40","min":0},"genres":["喜剧","运动"],"title":"恋爱回旋","casts":[{"alt":"https://movie.douban.com/celebrity/1018562/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1747.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1747.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1747.webp"},"name":"新垣结衣","id":"1018562"},{"alt":"https://movie.douban.com/celebrity/1037363/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6642.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6642.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6642.webp"},"name":"瑛太","id":"1037363"},{"alt":"https://movie.douban.com/celebrity/1098533/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50678.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50678.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p50678.webp"},"name":"广末凉子","id":"1098533"}],"collect_count":26471,"original_title":"ミックス。","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1337094/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483245452.11.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483245452.11.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1483245452.11.webp"},"name":"石川淳一","id":"1337094"}],"year":"2017","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515437624.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515437624.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515437624.webp"},"alt":"https://movie.douban.com/subject/26972275/","id":"26972275"},{"rating":{"max":10,"average":5.2,"stars":"25","min":0},"genres":["喜剧","奇幻"],"title":"捉妖记2","casts":[{"alt":"https://movie.douban.com/celebrity/1115918/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33525.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33525.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33525.webp"},"name":"梁朝伟","id":"1115918"},{"alt":"https://movie.douban.com/celebrity/1275542/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21559.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21559.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p21559.webp"},"name":"白百何","id":"1275542"},{"alt":"https://movie.douban.com/celebrity/1274628/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp"},"name":"井柏然","id":"1274628"}],"collect_count":107904,"original_title":"捉妖记2","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1287124/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42488.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42488.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p42488.webp"},"name":"许诚毅","id":"1287124"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2509643816.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2509643816.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2509643816.webp"},"alt":"https://movie.douban.com/subject/26575103/","id":"26575103"},{"rating":{"max":10,"average":6,"stars":"30","min":0},"genres":["动画"],"title":"虎皮萌企鹅","casts":[{"alt":"https://movie.douban.com/celebrity/1389534/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"菲利普·波佐","id":"1389534"},{"alt":"https://movie.douban.com/celebrity/1389535/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"劳伦·默度","id":"1389535"},{"alt":"https://movie.douban.com/celebrity/1389536/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"帕斯卡尔·卡萨诺瓦","id":"1389536"}],"collect_count":1314,"original_title":"Les As de la Jungle","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1381275/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pMe815TL3qFkcel_avatar_uploaded1505356619.35.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pMe815TL3qFkcel_avatar_uploaded1505356619.35.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pMe815TL3qFkcel_avatar_uploaded1505356619.35.webp"},"name":"大卫阿拉克斯","id":"1381275"}],"year":"2017","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516086487.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516086487.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516086487.webp"},"alt":"https://movie.douban.com/subject/27076492/","id":"27076492"},{"rating":{"max":10,"average":6.8,"stars":"35","min":0},"genres":["喜剧","动画","冒险"],"title":"妈妈咪鸭","casts":[{"alt":"https://movie.douban.com/celebrity/1349631/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495370690.02.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495370690.02.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495370690.02.webp"},"name":"赵路","id":"1349631"},{"alt":"https://movie.douban.com/celebrity/1385413/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331168.87.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331168.87.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331168.87.webp"},"name":"武皓栋","id":"1385413"},{"alt":"https://movie.douban.com/celebrity/1350671/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331194.34.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331194.34.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331194.34.webp"},"name":"殷筱瑜","id":"1350671"}],"collect_count":2074,"original_title":"妈妈咪鸭","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1385830/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331279.72.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331279.72.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331279.72.webp"},"name":"赵锐","id":"1385830"},{"alt":"https://movie.douban.com/celebrity/1303136/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331306.63.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331306.63.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513331306.63.webp"},"name":"克里斯托弗·詹金斯","id":"1303136"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515018270.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515018270.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2515018270.webp"},"alt":"https://movie.douban.com/subject/26603666/","id":"26603666"},{"rating":{"max":10,"average":6.8,"stars":"35","min":0},"genres":["喜剧","动画","冒险"],"title":"熊出没·变形记","casts":[{"alt":"https://movie.douban.com/celebrity/1336920/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451196460.57.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451196460.57.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451196460.57.webp"},"name":"张伟","id":"1336920"},{"alt":"https://movie.douban.com/celebrity/1336919/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451196097.21.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451196097.21.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1451196097.21.webp"},"name":"张秉君","id":"1336919"},{"alt":"https://movie.douban.com/celebrity/1336930/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1497954031.89.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1497954031.89.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1497954031.89.webp"},"name":"谭笑","id":"1336930"}],"collect_count":6386,"original_title":"熊出没·变形记","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1336904/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519556086.74.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519556086.74.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1519556086.74.webp"},"name":"丁亮","id":"1336904"},{"alt":"https://movie.douban.com/celebrity/1336917/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492836254.8.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492836254.8.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1492836254.8.webp"},"name":"林汇达","id":"1336917"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506889386.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506889386.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506889386.webp"},"alt":"https://movie.douban.com/subject/27176717/","id":"27176717"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["悬疑","惊悚"],"title":"玲珑井","casts":[{"alt":"https://movie.douban.com/celebrity/1329270/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1400230886.32.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1400230886.32.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1400230886.32.webp"},"name":"宋睿","id":"1329270"},{"alt":"https://movie.douban.com/celebrity/1341569/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1406089479.1.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1406089479.1.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1406089479.1.webp"},"name":"罗翔","id":"1341569"},{"alt":"https://movie.douban.com/celebrity/1354039/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6yqPZc1SzQcel_avatar_uploaded1452747554.83.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6yqPZc1SzQcel_avatar_uploaded1452747554.83.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6yqPZc1SzQcel_avatar_uploaded1452747554.83.webp"},"name":"曾漪莲","id":"1354039"}],"collect_count":181,"original_title":"玲珑井","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1379657/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"海鹏","id":"1379657"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516155261.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516155261.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516155261.webp"},"alt":"https://movie.douban.com/subject/26984234/","id":"26984234"}]
     * title : 正在上映的电影-北京
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":5.8,"stars":"30","min":0}
         * genres : ["动作","科幻","冒险"]
         * title : 环太平洋：雷霆再起
         * casts : [{"alt":"https://movie.douban.com/celebrity/1339915/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp"},"name":"约翰·博耶加","id":"1339915"},{"alt":"https://movie.douban.com/celebrity/1000188/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1418720473.76.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1418720473.76.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1418720473.76.webp"},"name":"斯科特·伊斯特伍德","id":"1000188"},{"alt":"https://movie.douban.com/celebrity/1362560/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1479205212.79.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1479205212.79.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1479205212.79.webp"},"name":"卡莉·史派妮","id":"1362560"}]
         * collect_count : 62199
         * original_title : Pacific Rim: Uprising
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1340823/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp"},"name":"斯蒂文·S·迪奈特","id":"1340823"}]
         * year : 2018
         * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512933684.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512933684.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512933684.webp"}
         * alt : https://movie.douban.com/subject/20435622/
         * id : 20435622
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 5.8
             * stars : 30
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512933684.webp
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512933684.webp
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2512933684.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1339915/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp"}
             * name : 约翰·博耶加
             * id : 1339915
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1447164061.84.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1340823/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp"}
             * name : 斯蒂文·S·迪奈特
             * id : 1340823
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBeanX {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/pqiCuEHOtvNIcel_avatar_uploaded1403339434.41.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}
