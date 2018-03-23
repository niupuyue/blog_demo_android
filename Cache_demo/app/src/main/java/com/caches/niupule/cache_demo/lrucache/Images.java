package com.caches.niupule.cache_demo.lrucache;

/**
 * Created: niupule
 * Date: 2018/3/23  下午9:43
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class Images {

    public final static String[] imageThumbUrls = new String[] {
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984897&di=84b2dfd8f54bf67e7ab9738d3c20dd1f&imgtype=0&src=http%3A%2F%2Fwww.qqpk.cn%2Fpicture%2FFiles%2F201408%2F2014082517081251_S.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984897&di=a81051e17e9bcb770b2c010b38387981&imgtype=0&src=http%3A%2F%2Fs9.knowsky.com%2Ftupian%2Fstu%2F1%2F2012021411063790688.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984897&di=668cf0e49b77fb7bca479597bdc0303f&imgtype=0&src=http%3A%2F%2Fimg.bimg.126.net%2Fphoto%2FNWoWebMmzGHLJ9NbiQcmxg%3D%3D%2F5406852827651787984.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984896&di=cc37c2551ac9df5d4c5a3eb1e6b3094c&imgtype=0&src=http%3A%2F%2Fpccoo.cn%2Fbbs%2F20130613%2F20130613153235391s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984896&di=09e6eb8df89ac2959ffa4e40091c4bb4&imgtype=0&src=http%3A%2F%2Fwww.qqpk.cn%2Fpicture%2FFiles%2F201408%2F2014082517513485_S.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984896&di=53d85f020245458945a79a67cdb071cb&imgtype=0&src=http%3A%2F%2Fs9.knowsky.com%2Ftupian%2Fstu%2F1%2F2012021410524718790.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984896&di=ce925f3466f5fc229f1fbb94b5839a23&imgtype=0&src=http%3A%2F%2Fwww.qqpk.cn%2Fpicture%2FFiles%2F201408%2F2014082519064210_S.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3144908197,3471937066&fm=27&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984896&di=317eb86ef8bf59d4e579140807b42880&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F2010613%2F201061322570854s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984895&di=62520a0054d75df7f0ad1b10942098f8&imgtype=0&src=http%3A%2F%2Fwww.qqpk.cn%2Fpicture%2FFiles%2F201408%2F2014082517163728_S.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984895&di=706d01a2ae20af48ccf977559d3de538&imgtype=0&src=http%3A%2F%2Fwap.qqpk.cn%2Fpicture%2FFiles%2F201408%2F2014082517165032_S.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984895&di=143c61c55e093ab3e7b3ad74c33bab2b&imgtype=0&src=http%3A%2F%2Fpccoo.cn%2Fbbs%2F20130613%2F20130613152411047s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823147648&di=b7fbe05d9f6d8cea62876460fd570e9a&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D523833605%2C446984562%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984895&di=98bdf33979af369d3b092d3970566986&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F2010630%2F20106301018287s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984895&di=48ee36a89b711be6264be06fab472f15&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F201075%2F20107510465589s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984895&di=ed04f361e92a2f5efea92ac5d35d0a8d&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F20111027%2F2011102710513318s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984894&di=27135978fdd278b0b613ae67f519580c&imgtype=0&src=http%3A%2F%2Fg-search1.alicdn.com%2Fimg%2Fbao%2Fuploaded%2Fi2%2FTB17JfBIFXXXXXjXXXXXXXXXXXX_%2521%25210-item_pic.jpg_160x160.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984894&di=5881b28a2c084d034d5aa990dc77d57b&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F20091223%2F2009122310332867s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984894&di=69417832cded154fba01e4ab660ac60d&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F20111024%2F20111024154255199s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984893&di=8c08e666426b52929462f6e171f93c0d&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F2011430%2F201143023023976s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823234577&di=ce6482bf93458a7cb2ebe1017e40fb0d&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D3256993052%2C4205754286%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984893&di=282c82ac1de47043db309f821e6670d6&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F2012119%2F20121192157053s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984893&di=84ed4ebd27a867b84b6b035649b2f357&imgtype=0&src=http%3A%2F%2Fpccoo.cn%2Fbbs%2F20130613%2F20130613153556016s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984892&di=09e14bfcc16895f8b5158e855c98a134&imgtype=0&src=http%3A%2F%2Fpccoo.cn%2Fbbs%2F20120806%2F20120806202803597s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984891&di=3a4d6eb33dd8bb49dc64d6d62404066d&imgtype=0&src=http%3A%2F%2Fpccoo.cn%2Fbbs%2F20130424%2F20130424114122946s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984890&di=d03eae5abc21f8b05a3d039f35639598&imgtype=0&src=http%3A%2F%2Fwww.qqpk.cn%2Fpicture%2FFiles%2F201408%2F2014082519084523_S.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823297424&di=5bc453ac6b621646c8a9aeddd335dd9e&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D88687665%2C2077001911%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823306433&di=7ee521d7f05ab1f994c44228696092e8&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D2577014739%2C1657028962%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984890&di=fc215b0e3307a539ba2005c9d0df02cc&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F2010619%2F201061911162044s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521822984889&di=ec4b7aa3abfdfc47f89151df758bf49b&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F2010630%2F201063010252228s.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2076629161,1388020412&fm=15&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823277123&di=e342670f3eb41af7d6b4ae3436be2013&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F201038%2F20103816200427s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823277122&di=66fb6ae97ea731347b1d6797b0e4568c&imgtype=0&src=http%3A%2F%2Fg-search1.alicdn.com%2Fimg%2Fbao%2Fuploaded%2Fi2%2FTB19lnDIFXXXXbnaXXXXXXXXXXX_%2521%25210-item_pic.jpg_160x160.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823277122&di=2b8609095bc923ed36e5de4bb691874d&imgtype=0&src=http%3A%2F%2Fpic.baike.soso.com%2Fp%2F20090109%2Fext-20090109120000-106878.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823374928&di=0efbfcd6f0660f4402dd1ceda329d395&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D3130275906%2C4147869016%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823384013&di=92e28f99cef5eaba4c1d555822c88a17&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D1838641907%2C3883699486%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823391971&di=9f07d1a09c2b69716a2289b8bfb16680&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D3595149526%2C3311628352%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823277121&di=7924d5a7a390003886479720740adfdf&imgtype=0&src=http%3A%2F%2Fwap.qqpk.cn%2Fpicture%2FFiles%2F201408%2F2014082517145818_S.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823431942&di=1b85c96233e4b300931f4cca662c0244&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D1111645958%2C1402987284%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823277121&di=914eb8c5ce1c3cdb430afcce852a94c9&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F2010615%2F201061518442313s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823452496&di=ba6a1b3ce2588d9472b80a15089fb6f7&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D857545635%2C1437288366%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823277120&di=eef1efd1f0dbe91a748cdb5ae57b6f89&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F201066%2F20106616534449s.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823277120&di=812d747b8c3e99857981b4ff86a200c1&imgtype=0&src=http%3A%2F%2Fstatic.house.sina.com.cn%2Fsupportsjiaju%2Fproduct%2Ff9%2Fde%2Fo453115001267546911_160x160.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521823277119&di=574cc489a5d3679592f66e8c9594163c&imgtype=0&src=http%3A%2F%2Fimages.pccoo.cn%2Fbbs%2F2010628%2F201062818193047s.jpg"
    };
}