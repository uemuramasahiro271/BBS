package com.bbs.app.entity;

import java.util.Date;

public class Contents extends ContentsKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contents.contributor
     *
     * @mbg.generated Mon Aug 31 21:23:56 JST 2020
     */
    private String contributor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contents.date
     *
     * @mbg.generated Mon Aug 31 21:23:56 JST 2020
     */
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column contents.text
     *
     * @mbg.generated Mon Aug 31 21:23:56 JST 2020
     */
    private String text;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contents.contributor
     *
     * @return the value of contents.contributor
     *
     * @mbg.generated Mon Aug 31 21:23:56 JST 2020
     */
    public String getContributor() {
        return contributor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contents.contributor
     *
     * @param contributor the value for contents.contributor
     *
     * @mbg.generated Mon Aug 31 21:23:56 JST 2020
     */
    public void setContributor(String contributor) {
        this.contributor = contributor == null ? null : contributor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contents.date
     *
     * @return the value of contents.date
     *
     * @mbg.generated Mon Aug 31 21:23:56 JST 2020
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contents.date
     *
     * @param date the value for contents.date
     *
     * @mbg.generated Mon Aug 31 21:23:56 JST 2020
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column contents.text
     *
     * @return the value of contents.text
     *
     * @mbg.generated Mon Aug 31 21:23:56 JST 2020
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column contents.text
     *
     * @param text the value for contents.text
     *
     * @mbg.generated Mon Aug 31 21:23:56 JST 2020
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}