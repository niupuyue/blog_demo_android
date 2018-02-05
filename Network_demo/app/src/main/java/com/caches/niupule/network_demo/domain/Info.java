package com.caches.niupule.network_demo.domain;

import java.util.List;

/**
 * Created: niupule
 * Date: 2018/2/5  下午11:03
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class Info {


    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"content":"学校论坛上有人问：\u201c为啥明明用了除蟑螂的药，蟑螂却越来越多了。\u201d某个学生回帖：\u201c如果你家人不见了，你不出来找吗？你会不着急么？\u201d","hashId":"8196907ee902f3508b9be6ea59d2191c","unixtime":1478598830,"updatetime":"2016-11-08 17:53:50"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * content : 学校论坛上有人问：“为啥明明用了除蟑螂的药，蟑螂却越来越多了。”某个学生回帖：“如果你家人不见了，你不出来找吗？你会不着急么？”
             * hashId : 8196907ee902f3508b9be6ea59d2191c
             * unixtime : 1478598830
             * updatetime : 2016-11-08 17:53:50
             */

            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }
        }
    }
}
