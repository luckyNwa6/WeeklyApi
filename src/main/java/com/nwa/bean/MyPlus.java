package com.nwa.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Lucky友人a
 * @Date 2023/7/6 -18:58
 */
@TableName(value = "tb_weeks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "周报里面的实体", description = "封装的周报对象")//文档响应的类说明
public class MyPlus {
    @ApiModelProperty("外键")
    private String monthsId;

    @ApiModelProperty("本周总结1")
    private String summary1;

    @ApiModelProperty("本周总结2")
    private String summary2;

    @ApiModelProperty("本周总结3")
    private String summary3;

    @ApiModelProperty("计划1")
    private String plan1;

    @ApiModelProperty("计划2")
    private String plan2;

    @ApiModelProperty("计划3")
    private String plan3;

    @ApiModelProperty("周1上午事情1")
    @TableField(value = "monMoA1")
    private String monMoA1;

    @ApiModelProperty("周1上午事情2")
    @TableField(value = "monMoA2")
    private String monMoA2;

    @ApiModelProperty("周1上午结果1")
    @TableField(value = "monMoR1")
    private String monMoR1;

    @ApiModelProperty("周1上午结果2")
    @TableField(value = "monMoR2")
    private String monMoR2;

    @ApiModelProperty("周1上午事情1状态")
    @TableField(value = "monMoA1S")
    private String monMoA1S;

    @ApiModelProperty("周1上午事情2状态")
    @TableField(value = "monMoA2S")
    private String monMoA2S;

    @ApiModelProperty("周1下午事情1")
    @TableField(value = "monAfA1")
    private String monAfA1;

    @ApiModelProperty("周1下午事情2")
    @TableField(value = "monAfA2")
    private String monAfA2;

    @ApiModelProperty("周1下午结果1")
    @TableField(value = "monAfR1")
    private String monAfR1;


    @ApiModelProperty("周1下午结果2")
    @TableField(value = "monAfR2")
    private String monAfR2;


    @ApiModelProperty("周1下午事情1状态")
    @TableField(value = "monAfA1S")
    private String monAfA1S;


    @ApiModelProperty("周1下午事情2状态")
    @TableField(value = "monAfA2S")
    private String monAfA2S;

    @ApiModelProperty("周2上午事情1")
    @TableField(value = "tuMoA1")
    private String tuMoA1;

    @ApiModelProperty("周2上午事情2")
    @TableField(value = "tuMoA2")
    private String tuMoA2;

    @ApiModelProperty("周2上午结果1")
    @TableField(value = "tuMoR1")
    private String tuMoR1;

    @ApiModelProperty("周2上午结果2")
    @TableField(value = "tuMoR2")
    private String tuMoR2;

    @ApiModelProperty("周2上午事情1状态")
    @TableField(value = "tuMoA1S")
    private String tuMoA1S;

    @ApiModelProperty("周2上午事情2状态")
    @TableField(value = "tuMoA2S")
    private String tuMoA2S;

    @ApiModelProperty("周2下午事情1")
    @TableField(value = "tuAfA1")
    private String tuAfA1;

    @ApiModelProperty("周2下午事情2")
    @TableField(value = "tuAfA2")
    private String tuAfA2;

    @ApiModelProperty("周2下午结果1")
    @TableField(value = "tuAfR1")
    private String tuAfR1;

    @ApiModelProperty("周2下午结果2")
    @TableField(value = "tuAfR2")
    private String tuAfR2;

    @ApiModelProperty("周2下午事情1状态")
    @TableField(value = "tuAfA1S")
    private String tuAfA1S;

    @ApiModelProperty("周2下午事情2状态")
    @TableField(value = "tuAfA2S")
    private String tuAfA2S;

    @ApiModelProperty("周3上午事情1")
    @TableField(value = "weMoA1")
    private String weMoA1;

    @ApiModelProperty("周3上午事情2")
    @TableField(value = "weMoA2")
    private String weMoA2;

    @ApiModelProperty("周3上午结果1")
    @TableField(value = "weMoR1")
    private String weMoR1;

    @ApiModelProperty("周3上午结果2")
    @TableField(value = "weMoR2")
    private String weMoR2;

    @TableField(value = "weMoA1S")
    @ApiModelProperty("周3上午事情1状态")
    private String weMoA1S;

    @ApiModelProperty("周3上午事情2状态")
    @TableField(value = "weMoA2S")
    private String weMoA2S;

    @ApiModelProperty("周3下午事情1")
    @TableField(value = "weAfA1")
    private String weAfA1;

    @ApiModelProperty("周3下午事情2")
    @TableField(value = "weAfA2")
    private String weAfA2;

    @ApiModelProperty("周3下午结果1")
    @TableField(value = "weAfR1")
    private String weAfR1;

    @ApiModelProperty("周3下午结果2")
    @TableField(value = "weAfR2")
    private String weAfR2;

    @ApiModelProperty("周3下午事情1状态")
    @TableField(value = "weAfA1S")
    private String weAfA1S;

    @ApiModelProperty("周3下午事情2状态")
    @TableField(value = "weAfA2S")
    private String weAfA2S;

    @ApiModelProperty("周4上午事情1")
    @TableField(value = "thMoA1")
    private String thMoA1;

    @ApiModelProperty("周4上午事情2")
    @TableField(value = "thMoA2")
    private String thMoA2;

    @ApiModelProperty("周4上午结果1")
    @TableField(value = "thMoR1")
    private String thMoR1;

    @ApiModelProperty("周4上午结果2")
    @TableField(value = "thMoR2")
    private String thMoR2;

    @ApiModelProperty("周4上午事情1状态")
    @TableField(value = "thMoA1S")
    private String thMoA1S;

    @ApiModelProperty("周4上午事情2状态")
    @TableField(value = "thMoA2S")
    private String thMoA2S;

    @ApiModelProperty("周4下午事情1")
    @TableField(value = "thAfA1")
    private String thAfA1;

    @ApiModelProperty("周4下午事情2")
    @TableField(value = "thAfA2")
    private String thAfA2;

    @ApiModelProperty("周4下午结果1")
    @TableField(value = "thAfR1")
    private String thAfR1;

    @ApiModelProperty("周4下午结果2")
    @TableField(value = "thAfR2")
    private String thAfR2;

    @ApiModelProperty("周4下午事情1状态")
    @TableField(value = "thAfA1S")
    private String thAfA1S;

    @ApiModelProperty("周4下午事情2状态")
    @TableField(value = "thAfA2S")
    private String thAfA2S;

    @ApiModelProperty("周5上午事情1")
    @TableField(value = "frMoA1")
    private String frMoA1;

    @ApiModelProperty("周5上午事情2")
    @TableField(value = "frMoA2")
    private String frMoA2;

    @ApiModelProperty("周5上午结果1")
    @TableField(value = "frMoR1")
    private String frMoR1;

    @ApiModelProperty("周5上午结果2")
    @TableField(value = "frMoR2")
    private String frMoR2;

    @ApiModelProperty("周5上午事情1状态")
    @TableField(value = "frMoA1S")
    private String frMoA1S;

    @ApiModelProperty("周5上午事情2状态")
    @TableField(value = "frMoA2S")
    private String frMoA2S;

    @ApiModelProperty("周5下午事情1")
    @TableField(value = "frAfA1")
    private String frAfA1;

    @ApiModelProperty("周5下午事情2")
    @TableField(value = "frAfA2")
    private String frAfA2;

    @ApiModelProperty("周5下午结果1")
    @TableField(value = "frAfR1")
    private String frAfR1;

    @ApiModelProperty("周5下午结果2")
    @TableField(value = "frAfR2")
    private String frAfR2;

    @ApiModelProperty("周5下午事情1状态")
    @TableField(value = "frAfA1S")
    private String frAfA1S;


    @ApiModelProperty("周5下午事情2状态")
    @TableField(value = "frAfA2S")
    private String frAfA2S;

    @ApiModelProperty("周6上午事情1")
    @TableField(value = "saMoA1")
    private String saMoA1;

    @ApiModelProperty("周6上午事情2")
    @TableField(value = "saMoA2")
    private String saMoA2;

    @ApiModelProperty("周6上午结果1")
    @TableField(value = "saMoR1")
    private String saMoR1;

    @ApiModelProperty("周6上午结果2")
    @TableField(value = "saMoR2")
    private String saMoR2;


    @ApiModelProperty("周6上午事情1状态")
    @TableField(value = "saMoA1S")
    private String saMoA1S;

    @ApiModelProperty("周6上午事情2状态")
    @TableField(value = "saMoA2S")
    private String saMoA2S;

    @ApiModelProperty("周6下午事情1")
    @TableField(value = "saAfA1")
    private String saAfA1;

    @ApiModelProperty("周6下午事情2")
    @TableField(value = "saAfA2")
    private String saAfA2;

    @TableField(value = "saAfR1")
    @ApiModelProperty("周6下午结果1")
    private String saAfR1;

    @TableField(value = "saAfR2")
    @ApiModelProperty("周6下午结果2")
    private String saAfR2;


    @ApiModelProperty("周6下午事情1状态")
    @TableField(value = "saAfA1S")
    private String saAfA1S;

    @ApiModelProperty("周6下午事情2状态")
    @TableField(value = "saAfA2S")
    private String saAfA2S;

    @ApiModelProperty("周7上午事情1")
    @TableField(value = "suMoA1")
    private String suMoA1;

    @ApiModelProperty("周7上午事情2")
    @TableField(value = "suMoA2")
    private String suMoA2;

    @ApiModelProperty("周7上午结果1")
    @TableField(value = "suMoR1")
    private String suMoR1;

    @ApiModelProperty("周7上午结果2")
    @TableField(value = "suMoR2")
    private String suMoR2;

    @ApiModelProperty("周7上午事情1状态")
    @TableField(value = "suMoA1S")
    private String suMoA1S;

    @ApiModelProperty("周7上午事情2状态")
    @TableField(value = "suMoA2S")
    private String suMoA2S;

    @ApiModelProperty("周7下午事情1")
    @TableField(value = "suAfA1")
    private String suAfA1;

    @ApiModelProperty("周7下午事情2")
    @TableField(value = "suAfA2")
    private String suAfA2;


    @ApiModelProperty("周7下午结果1")
    @TableField(value = "suAfR1")
    private String suAfR1;

    @ApiModelProperty("周7下午结果2")
    @TableField(value = "suAfR2")
    private String suAfR2;

    @ApiModelProperty("周7下午事情1状态")
    @TableField(value = "suAfA1S")
    private String suAfA1S;

    @ApiModelProperty("周7下午事情2状态")
    @TableField(value = "suAfA2S")
    private String suAfA2S;


}
