package top.threshold.ktscaffold.aspect

import cn.hutool.core.util.IdUtil
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import top.threshold.ktscaffold.constant.Const

@Component
class MDCInterceptor : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        //如果有上层调用就用上层的ID
        var traceId = request.getHeader(Const.TRACE_ID)
        if (traceId == null) {
            traceId = IdUtil.randomUUID()
        }

        MDC.put(Const.TRACE_ID, traceId)
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
    }


    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        response.setHeader(Const.TRACE_ID, MDC.get(Const.TRACE_ID))
        //调用结束后删除
        MDC.remove(Const.TRACE_ID)
    }
}