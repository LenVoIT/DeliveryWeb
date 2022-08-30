<%-- 
    Document   : ordership
    Created on : Aug 26, 2022, 10:28:02 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
    <section class="py-7">
        <div class="container">
            <h1 class="text-center">Quản lý đơn hàng</h1>
            <div class="row">
                <div class="table-responsive table-hover">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">Nhập thông tin đơn hàng cần tìm</label>
                                        <input name="Search" class="form-control">
                                    </div>
                                    <button type="button" class="btn bg-gradient-light">
                                        <a href="<c:url value=""/>">
                                            <i class="fas fa-search me-1">Tìm kiếm</i>
                                        </a>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
                            <table id="dtBasicExample" class="table table-hover table-bordered table-sm" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th class="th-sm">Tên người nhận
                                        </th>
                                        <th class="th-sm">Thời gian đặt
                                        </th>
                                        <th class="th-sm">Thời gian gửi
                                        </th>
                                        <th class="th-sm">Thời gian nhận
                                        </th>
                                        <th class="th-sm">Quyền
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orderList}" var="o">
                                        <tr>
                                            <td>${o.shipName}</td>
                                            <td>${o.orderDate}</td>
                                            <td>${o.requiredDate}</td>
                                            <td>${o.shippedDate}</td>
                                            <td>
                                                <a href="<c:url value="/coach-line"/>?id=${o.id}">Xem chi tiết</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>