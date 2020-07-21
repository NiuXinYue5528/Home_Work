package com.example.day08_lxc8.bean;

import java.util.List;

public class NameBean {
    /**
     * code : 200
     * body : {"result":[{"description":"介绍","teacherpowerid":"0"},{"teacherpowerid":1,"description":"课程"}]}
     * message : Succes!
     */

    private int code;
    private BodyBean body;
    private String message;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class BodyBean {
        private List<ResultBean> result;

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * description : 介绍
             * teacherpowerid : 0
             */

            private String description;
            private String teacherpowerid;
            private int id;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getTeacherpowerid() {
                return teacherpowerid;
            }

            public void setTeacherpowerid(String teacherpowerid) {
                this.teacherpowerid = teacherpowerid;
            }
        }
    }
}
