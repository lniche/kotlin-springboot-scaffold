package top.threshold.ktscaffold.entity.vo

import jakarta.validation.constraints.NotBlank
import lombok.Data

@Data
class UserVO {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    var username: String? = null

    /**
     * 昵称
     */
    var nickname: String? = null

    /**
     * 用户编号
     */
    var userNo: Long? = null

    /**
     * 用户编码
     */
    var userCode: String? = null

    /**
     * 电子邮件
     */
    var email: String? = null

    /**
     * 电话号码
     */
    var phone: String? = null
}
