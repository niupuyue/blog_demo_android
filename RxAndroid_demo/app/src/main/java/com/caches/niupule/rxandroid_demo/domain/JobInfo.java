package com.caches.niupule.rxandroid_demo.domain;

import java.util.List;

/**
 * Created: niupule
 * Date: 2018/2/6  上午12:01
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class JobInfo {


    /**
     * flag : success
     * data : [{"j_id":1,"j_name":"前端工程师","c_id":1,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"广州腾科网络科技有限公司","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"民营企业","c_numbers":200,"c_summary":"广州腾科是一家以IT技术培训为主，兼容各种IT人才培养方案，企业级服务定制，外包定制的综合性网络公司。公司成立于2007年，经过11年几代人的拼搏和努力，广州腾科公司已经成为华南地区家喻户晓的培训机构","c_images":"http://localhost:3000/images/togogo.jpg","c_others":null},{"j_id":2,"j_name":"web工程师","c_id":2,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"京东商城","c_address":"北京市朝阳区","c_url":"http://www.jd.com","c_phone":"020-123456","c_type":"民营企业","c_numbers":2000,"c_summary":"京东商城目前已经是中国最大的自营性电商企业，京东拥有中国最大的物流基础设配，通过完善布局，京东将成为全球唯一拥有中小件，大件灯物流设备的电商企业","c_images":"http://localhost:3000/images/jingdong.jpg","c_others":null},{"j_id":3,"j_name":"nodejs后台工程师","c_id":3,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"杭州阿里巴巴控股有限公司","c_address":"浙江省杭州市","c_url":"http://www.taobao.com","c_phone":"020-123456","c_type":"民营企业","c_numbers":1000,"c_summary":"阿里巴巴是中国目前最大的网上购物平台淘宝的母公司，旗下支付宝也是家喻户晓，全球五百强企业","c_images":"http://localhost:3000/images/alibaba.jpg","c_others":null},{"j_id":4,"j_name":"全栈工程师","c_id":4,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"久邦数码","c_address":"广东省广州市","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"民营企业","c_numbers":1000,"c_summary":"广州久邦数码是全球领先的移动互联网应用服务和广告平台，旗下业务包括面向全球用户的移动应用app，面向全国用户的旧版文学等。同时也是中国第一家在美国独立上市的移动互联网企业","c_images":"http://localhost:3000/images/kugou.jpg","c_others":null},{"j_id":5,"j_name":"java工程师","c_id":5,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"网易","c_address":"北京市西北旺","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"民营企业","c_numbers":200,"c_summary":"中国领先的互联网技术公司，在开发互联网应用，服务和其他技术方面，网易始终保持国内业界的领先地位。网易对中国互联网发展具有强烈的使命感，利用最先进的技术实现网聚人的力量","c_images":"http://localhost:3000/images/wangyi.jpg","c_others":null},{"j_id":6,"j_name":"android工程师","c_id":6,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"当当网","c_address":"北京左家庄","c_url":"http://www.dangdang.com","c_phone":"020-123456","c_type":"民营企业","c_numbers":200,"c_summary":"全球知名综合网上购物商城","c_images":"http://localhost:3000/images/meirong.jpg","c_others":null},{"j_id":7,"j_name":"UI设计工程师","c_id":7,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"腾讯","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.Tencent.com","c_phone":"020-123456","c_type":"民营企业","c_numbers":200,"c_summary":"好公司","c_images":"http://localhost:3000/images/tencent.jpg","c_others":null},{"j_id":8,"j_name":"前端工程师","c_id":8,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"金山","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"外资企业","c_numbers":200,"c_summary":"好公司","c_images":"http://localhost:3000/images/oppo.jpg","c_others":null},{"j_id":9,"j_name":"web工程师","c_id":9,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"中国人寿","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"国营企业","c_numbers":200,"c_summary":"好公司","c_images":"http://localhost:3000/images/ouyan.jpg","c_others":null},{"j_id":10,"j_name":"前端工程师","c_id":10,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"中国石化","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"国营企业","c_numbers":200,"c_summary":"好公司","c_images":"http://localhost:3000/images/gps.jpg","c_others":null},{"j_id":11,"j_name":"nodejs后台工程师","c_id":11,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"中国移动","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"国营企业","c_numbers":200,"c_summary":"好公司","c_images":"http://localhost:3000/images/xiaomi.png","c_others":null},{"j_id":12,"j_name":"前端工程师","c_id":3,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"杭州阿里巴巴控股有限公司","c_address":"浙江省杭州市","c_url":"http://www.taobao.com","c_phone":"020-123456","c_type":"民营企业","c_numbers":1000,"c_summary":"阿里巴巴是中国目前最大的网上购物平台淘宝的母公司，旗下支付宝也是家喻户晓，全球五百强企业","c_images":"http://localhost:3000/images/alibaba.jpg","c_others":null},{"j_id":13,"j_name":"web工程师","c_id":2,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"京东商城","c_address":"北京市朝阳区","c_url":"http://www.jd.com","c_phone":"020-123456","c_type":"民营企业","c_numbers":2000,"c_summary":"京东商城目前已经是中国最大的自营性电商企业，京东拥有中国最大的物流基础设配，通过完善布局，京东将成为全球唯一拥有中小件，大件灯物流设备的电商企业","c_images":"http://localhost:3000/images/jingdong.jpg","c_others":null},{"j_id":14,"j_name":"java工程师","c_id":1,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"广州腾科网络科技有限公司","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"民营企业","c_numbers":200,"c_summary":"广州腾科是一家以IT技术培训为主，兼容各种IT人才培养方案，企业级服务定制，外包定制的综合性网络公司。公司成立于2007年，经过11年几代人的拼搏和努力，广州腾科公司已经成为华南地区家喻户晓的培训机构","c_images":"http://localhost:3000/images/togogo.jpg","c_others":null},{"j_id":15,"j_name":"前端工程师","c_id":4,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"久邦数码","c_address":"广东省广州市","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"民营企业","c_numbers":1000,"c_summary":"广州久邦数码是全球领先的移动互联网应用服务和广告平台，旗下业务包括面向全球用户的移动应用app，面向全国用户的旧版文学等。同时也是中国第一家在美国独立上市的移动互联网企业","c_images":"http://localhost:3000/images/kugou.jpg","c_others":null},{"j_id":16,"j_name":"nodejs后台工程师","c_id":5,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"网易","c_address":"北京市西北旺","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"民营企业","c_numbers":200,"c_summary":"中国领先的互联网技术公司，在开发互联网应用，服务和其他技术方面，网易始终保持国内业界的领先地位。网易对中国互联网发展具有强烈的使命感，利用最先进的技术实现网聚人的力量","c_images":"http://localhost:3000/images/wangyi.jpg","c_others":null},{"j_id":17,"j_name":"前端工程师","c_id":6,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"当当网","c_address":"北京左家庄","c_url":"http://www.dangdang.com","c_phone":"020-123456","c_type":"民营企业","c_numbers":200,"c_summary":"全球知名综合网上购物商城","c_images":"http://localhost:3000/images/meirong.jpg","c_others":null},{"j_id":18,"j_name":"web工程师","c_id":7,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"腾讯","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.Tencent.com","c_phone":"020-123456","c_type":"民营企业","c_numbers":200,"c_summary":"好公司","c_images":"http://localhost:3000/images/tencent.jpg","c_others":null},{"j_id":19,"j_name":"前端工程师","c_id":8,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"金山","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"外资企业","c_numbers":200,"c_summary":"好公司","c_images":"http://localhost:3000/images/oppo.jpg","c_others":null},{"j_id":20,"j_name":"nodejs后台工程师","c_id":9,"j_requires":"一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真","j_points":"公司待遇好，发展空间大","j_type":"全职","j_money":10000,"j_other":null,"c_name":"中国人寿","c_address":"广东省广州市天河区乐天大厦","c_url":"http://www.togogo.net","c_phone":"020-123456","c_type":"国营企业","c_numbers":200,"c_summary":"好公司","c_images":"http://localhost:3000/images/ouyan.jpg","c_others":null}]
     */

    private String flag;
    private List<DataBean> data;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * j_id : 1
         * j_name : 前端工程师
         * c_id : 1
         * j_requires : 一年工作经验，数量使用前端技术(html,css,js)，熟练使用前端框架(angularjs,vuejs)，对待工作积极认真
         * j_points : 公司待遇好，发展空间大
         * j_type : 全职
         * j_money : 10000
         * j_other : null
         * c_name : 广州腾科网络科技有限公司
         * c_address : 广东省广州市天河区乐天大厦
         * c_url : http://www.togogo.net
         * c_phone : 020-123456
         * c_type : 民营企业
         * c_numbers : 200
         * c_summary : 广州腾科是一家以IT技术培训为主，兼容各种IT人才培养方案，企业级服务定制，外包定制的综合性网络公司。公司成立于2007年，经过11年几代人的拼搏和努力，广州腾科公司已经成为华南地区家喻户晓的培训机构
         * c_images : http://localhost:3000/images/togogo.jpg
         * c_others : null
         */

        private int j_id;
        private String j_name;
        private int c_id;
        private String j_requires;
        private String j_points;
        private String j_type;
        private int j_money;
        private Object j_other;
        private String c_name;
        private String c_address;
        private String c_url;
        private String c_phone;
        private String c_type;
        private int c_numbers;
        private String c_summary;
        private String c_images;
        private Object c_others;

        public int getJ_id() {
            return j_id;
        }

        public void setJ_id(int j_id) {
            this.j_id = j_id;
        }

        public String getJ_name() {
            return j_name;
        }

        public void setJ_name(String j_name) {
            this.j_name = j_name;
        }

        public int getC_id() {
            return c_id;
        }

        public void setC_id(int c_id) {
            this.c_id = c_id;
        }

        public String getJ_requires() {
            return j_requires;
        }

        public void setJ_requires(String j_requires) {
            this.j_requires = j_requires;
        }

        public String getJ_points() {
            return j_points;
        }

        public void setJ_points(String j_points) {
            this.j_points = j_points;
        }

        public String getJ_type() {
            return j_type;
        }

        public void setJ_type(String j_type) {
            this.j_type = j_type;
        }

        public int getJ_money() {
            return j_money;
        }

        public void setJ_money(int j_money) {
            this.j_money = j_money;
        }

        public Object getJ_other() {
            return j_other;
        }

        public void setJ_other(Object j_other) {
            this.j_other = j_other;
        }

        public String getC_name() {
            return c_name;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }

        public String getC_address() {
            return c_address;
        }

        public void setC_address(String c_address) {
            this.c_address = c_address;
        }

        public String getC_url() {
            return c_url;
        }

        public void setC_url(String c_url) {
            this.c_url = c_url;
        }

        public String getC_phone() {
            return c_phone;
        }

        public void setC_phone(String c_phone) {
            this.c_phone = c_phone;
        }

        public String getC_type() {
            return c_type;
        }

        public void setC_type(String c_type) {
            this.c_type = c_type;
        }

        public int getC_numbers() {
            return c_numbers;
        }

        public void setC_numbers(int c_numbers) {
            this.c_numbers = c_numbers;
        }

        public String getC_summary() {
            return c_summary;
        }

        public void setC_summary(String c_summary) {
            this.c_summary = c_summary;
        }

        public String getC_images() {
            return c_images;
        }

        public void setC_images(String c_images) {
            this.c_images = c_images;
        }

        public Object getC_others() {
            return c_others;
        }

        public void setC_others(Object c_others) {
            this.c_others = c_others;
        }
    }
}
