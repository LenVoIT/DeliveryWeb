<%-- 
    Document   : Index
    Created on : Aug 5, 2022, 10:15:18 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Trang chu</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
            </head>
        <body>
        </body>-->
    <body class="">
        <div class="wrapper ">
            <div class="sidebar" data-color="orange">
                <!--
                  Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
                -->
                <div class="logo">
                    <a  class="simple-text logo-normal">
                        P&LMove
                    </a>
                </div>
                <div class="sidebar-wrapper" id="sidebar-wrapper">
                    <ul class="nav">
                        <li class="active ">
                            <a href="./">
                                <i class="now-ui-icons design_app"></i>
                                <p>Trang chủ</p>
                            </a>
                        </li>
                        <li>
                            <a href="./icons.html">
                                <!--                                <i class="now-ui-icons education_atom"></i>-->
                                <p>Về chúng tôi</p>
                            </a>
                        </li>
                        <li>
                            <a href="./map.html">
                                <!--                                <i class="now-ui-icons location_map-big"></i>-->
                                <p>Bản đồ</p>
                            </a>
                        </li>
                        <li>
                            <a href="./notifications.html">
                                <!--                                <i class="now-ui-icons ui-1_bell-53"></i>-->
                                <p>Thông báo</p>
                            </a>
                        </li>
                        <li>
                            <a href="./user.html">
                                <!--                                <i class="now-ui-icons users_single-02"></i>-->
                                <p>Thông tin cá nhân</p>
                            </a>
                        </li>
                        <li>
                            <a href="./tables.html">
                                <!--                                <i class="now-ui-icons design_bullet-list-67"></i>-->
                                <p>Danh sách đơn hàng</p>
                            </a>
                        </li>
                        <li>
                            <a href="./typography.html">
                                <!--                                <i class="now-ui-icons text_caps-small"></i>-->
                                <p>Liên hệ</p>
                            </a>
                        </li>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/manageaccount"/>">
                                    <!--                                    <i class="now-ui-icons design_bullet-list-67"></i>-->
                                    <p>Quản lý account</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/ordership"/>">
                                    <!--                                    <i class="now-ui-icons design_bullet-list-67"></i>-->
                                    <p>Quản lý đơn hàng</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/shippermanagebyadmin"/>">
                                    <!--                                    <i class="now-ui-icons users_single-02"></i>-->
                                    <p>Quản lý shipper</p>
                                </a>
                            </li>
                        </security:authorize>
                    </ul>
                </div>
            </div>
            <div class="main-panel" id="main-panel">

                <div class="panel-header panel-header-lg">
                    <canvas id="bigDashboardChart"></canvas>
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card card-chart">
                                <div class="card-header">
                                    <h4 class="card-title"><i class="fa fa-truck" aria-hidden="true"></i> P&L Truck</h4>
                                    <h5 class="card-body">Đa dạng phương tiện vận chuyển dành cho các mặt hàng lớn và cồng kềnh.</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="card card-chart">
                                <div class="card-header">
                                    <h4 class="card-title"><i class="fa fa-motorcycle" aria-hidden="true"></i> P&L Delivery</h4>
                                    <h5 class="card-body">Giao hàng nhanh, đảm bảo và giá tốt với dịch vụ phù hợp được tối ưu cho bạn.</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
