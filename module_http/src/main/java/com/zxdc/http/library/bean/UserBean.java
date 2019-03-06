package com.zxdc.http.library.bean;

import java.io.Serializable;

/**
 * 用户信息
 */

public class UserBean extends BaseBean{
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private String token;
        //用户id
        private String user_id;
        //证件号
        private String passport;
        //用户类型: 0临时用户，1注册用户，2会员用户
        private int user_type;
        //注册手机号
        private String mobile;
        //昵称
        private String nickname;
        //头像
        private String head;
        //账户状态: 0正常 ，1冻结，2删除
        private int acc_status;
        //用户余额（分）
        private double balance;
        //信用积分: 初始100
        private int credit_score;
        //正向加分: 累积加分值，具体加分项查对应日志，保修，举报，合理建议，志愿行为等
        private double bonus_point;
        //负面减分: 累积减分值，具体减分项查对应日志，违规，破坏等
        private double minus_point;
        //邀请码
        private String invite_no;
        //累积骑行里程(米)
        private double total_km;
        //累积骑行时间(分钟)
        private long total_time;
        //累积消耗(千卡)
        private double total_calorie;
        //累积减排(千克碳)
        private double total_emission_reduction;
        //禁停区临时锁车还车次数
        private int forbid_area;
        //会员等级
        private int member_rating;
        //会员权益开始时间（精确到秒）
        private long start_time;
        //会员权益到期时间（精确到秒）
        private long end_time;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getPassport() {
            return passport;
        }

        public void setPassport(String passport) {
            this.passport = passport;
        }

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public int getAcc_status() {
            return acc_status;
        }

        public void setAcc_status(int acc_status) {
            this.acc_status = acc_status;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public int getCredit_score() {
            return credit_score;
        }

        public void setCredit_score(int credit_score) {
            this.credit_score = credit_score;
        }

        public double getBonus_point() {
            return bonus_point;
        }

        public void setBonus_point(double bonus_point) {
            this.bonus_point = bonus_point;
        }

        public double getMinus_point() {
            return minus_point;
        }

        public void setMinus_point(double minus_point) {
            this.minus_point = minus_point;
        }

        public String getInvite_no() {
            return invite_no;
        }

        public void setInvite_no(String invite_no) {
            this.invite_no = invite_no;
        }

        public double getTotal_km() {
            return total_km;
        }

        public void setTotal_km(double total_km) {
            this.total_km = total_km;
        }

        public long getTotal_time() {
            return total_time;
        }

        public void setTotal_time(long total_time) {
            this.total_time = total_time;
        }

        public double getTotal_calorie() {
            return total_calorie;
        }

        public void setTotal_calorie(double total_calorie) {
            this.total_calorie = total_calorie;
        }

        public double getTotal_emission_reduction() {
            return total_emission_reduction;
        }

        public void setTotal_emission_reduction(double total_emission_reduction) {
            this.total_emission_reduction = total_emission_reduction;
        }

        public int getForbid_area() {
            return forbid_area;
        }

        public void setForbid_area(int forbid_area) {
            this.forbid_area = forbid_area;
        }

        public int getMember_rating() {
            return member_rating;
        }

        public void setMember_rating(int member_rating) {
            this.member_rating = member_rating;
        }

        public long getStart_time() {
            return start_time;
        }

        public void setStart_time(long start_time) {
            this.start_time = start_time;
        }

        public long getEnd_time() {
            return end_time;
        }

        public void setEnd_time(long end_time) {
            this.end_time = end_time;
        }

    }
}
