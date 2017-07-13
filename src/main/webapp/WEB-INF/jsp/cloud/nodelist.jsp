<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div class="index-box">
        <p class="box-name">实例</p>

        <p class="box-content">一个虚拟机启动之后生成的一个正在运行的系统，它有您期望的硬件配置、操作系统和网络配置。实例也称云服务器、云主机。</p>
    </div>

    <table class="table table-hover table-responsive table-font">
        <thead>
        <tr>
            <td><input type="checkbox" hidden/></td>
            <td>名称</td>
            <td>状态</td>
            <td>IP</td>
            <td>系统/规格</td>
            <td>角色</td>
            <td>创建人</td>
            <td>创建时间</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${nodes}" var="nodes">
            <tr class="nodes" node="${nodes.nodeName}"
                ip="${nodes.nodeIp}"
                contextPath="${pageContext.request.contextPath}">

                <td><input type="checkbox"/></td>
                <td><img src="${pageContext.request.contextPath}/assets/img/node/monitor.png"
                         class="img-responsive list-img"/>&nbsp;${nodes.nodeName}</td>
                <td>
                        <c:choose>
                        <c:when test="${nodes.nodeStatus == '运行中'}">
                        <img src="${pageContext.request.contextPath}/assets/img/node/running.png"
                             class="img-responsive list-img"/>&nbsp;<span>${nodes.nodeStatus}</span>
                        </c:when>
                        <c:otherwise>
                            <img src="${pageContext.request.contextPath}/assets/img/node/stoping.png"
                                 class="img-responsive list-img"/>&nbsp;<span>${nodes.nodeStatus}</span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>${nodes.nodeIp}</td>
                <td><img src="${pageContext.request.contextPath}/assets/img/node/ubuntu.png"
                         class="img-responsive list-img"> </img>${nodes.nodeSpecification}</td>
                <td>${nodes.nodeRole}</td>
                <td>${nodes.nodeCreater}</td>
                <td><fmt:formatDate value="${nodes.nodeTime}" pattern="yyyy-MM-dd HH:mm"/></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="contextMenu" id="menu">
    <ul>
        <li id="start">
            <img src="${pageContext.request.contextPath}/assets/img/node/start_16.png" width="16" height="16"/>
            启动
        </li>
        <li id="stop">
            <img src="${pageContext.request.contextPath}/assets/img/node/stop_16.png" width="16" height="16"/>
            关闭
        </li>
        <li id="monitor">
            <img src="${pageContext.request.contextPath}/assets/img/node/monitor.png" width="16" height="16"/>
            打开终端
        </li>
        <li id="about">
            <img src="${pageContext.request.contextPath}/assets/img/node/about_16.png" width="16" height="16"/>
            关于
        </li>
    </ul>
</div>

<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">关于</h4>
            </div>
            <div class="modal-body table-font">
                <p class="p-text">
                    Hadoop作为分布式和并行化的数据处理支撑点，为算法库的运行提供基础环境。其中，Hadoop可分为Master和Slave节点，通过云服务层的虚拟化技术，我们将硬件设备进行统一管理，并进行了计算资源的分配。
                </p>
                <p class="p-text">
                    Master节点是一个中心服务节点，负责管理文件系统的名字空间以及客户端对文件的访问，也负责对用户提交任务进行统一调度。Slave节点是一般子节点，负责管理它所在节点上的存储与处理文件系统客户端的读写请求，在Master的统一调度下进行数据块的创建、删除和复制，并执行Master分配的任务。
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<script src="${pageContext.request.contextPath}/assets/plugins/smartmenu/jquery.contextmenu.r2.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/scripts/cloud.js"></script>
<script type="text/javascript">
    $(function () {
        $('tr').contextMenu('menu',
                {
                    bindings: {
                        'start': function (t, target) {
                            var res = onoff('on', $(t).attr("ip"));
                            if (res == true) {
                                var contextPath = $(t).attr('contextPath');

                                $(t).children("td:eq(2)").children().html('<img src="' + contextPath + '/assets/img/node/running.png"' +
                                        'class="img-responsive list-img"/>&nbsp;' + '运行中');
                            }
                        },
                        'stop': function (t, target) {
                            var res = onoff('off', $(t).attr("ip"));
                            if (res == true) {
                                var contextPath = $(t).attr('contextPath');

                                $(t).children("td:eq(2)").children().html('<img src="' + contextPath + '/assets/img/node/stoping.png"' +
                                        'class="img-responsive list-img"/>&nbsp;' + '已关闭');
                            }
                        },
                        'monitor': function (t, target) {
                            shell($(t).attr("ip"), $(t).attr("node"));
                        },
                        'about': function (t, target) {
                            $('#myModal').modal('toggle');
                        }
                    },
                    onShowMenu: function (e, menu) {
                        $(e.currentTarget).children('td').children('input').attr('checked', true);
                        return menu;
                    }

                });
    })

    $("tr").click(function () {
        if ($(this).children('td').children('input').attr('checked')) {
            $(this).children('td').children('input').attr('checked', false);
        } else {
            $(this).children('td').children('input').attr('checked', true);
        }
    });
</script>

