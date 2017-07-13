<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div class="index-box">
        <p class="box-name">分布式集群</p>
        <p class="box-content">集群是一组相互独立的、通过高速网络互联的计算机，它们构成了一个组，并以单一系统的模式加以管理。一个客户与集群相互作用时，集群像是一个独立的服务器。</p>
    </div>

    <div>
        <p class="cluster-title bootcss">${clusters.clusterName}</p>

        <table class="table table-hover table-responsive table-font">
            <tbody>
                <tr>
                    <td>集群节点数</td>
                    <td>${clusters.clusterNodeNumber}</td>
                </tr>
                <tr>
                    <td>集群管理节点数</td>
                    <td>${clusters.clusterMasterNumber}</td>
                </tr>
                <tr>
                    <td>集群子节点数</td>
                    <td>${clusters.clusterNodeNumber}</td>
                </tr>
                <tr>
                    <td>集群存储节点</td>
                    <td>${clusters.clusterStorageNumber}</td>
                </tr>
                <tr>
                    <td>集群CPU总数</td>
                    <td>${clusters.clusterCpuNumber}</td>
                </tr>
                <tr>
                    <td>集群CPU核数</td>
                    <td>${clusters.clusterCpuKernelNumber}</td>
                </tr>
                <tr>
                    <td>集群总存储性能</td>
                    <td>${clusters.clusterTotalStorage}</td>
                </tr>
                <tr>
                    <td>集群总内存性能</td>
                    <td>${clusters.clusterTotalMomery}</td>
                </tr>
                <tr>
                    <td>集群预装系统</td>
                    <td>${clusters.clusterOs}</td>
                </tr>

            </tbody>
        </table>
    </div>

</div>

