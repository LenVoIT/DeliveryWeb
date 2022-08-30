<%-- 
    Document   : shippermanagebyadmin
    Created on : Aug 27, 2022, 10:25:03 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
    <section class="py-7">
        <div class="container">
            <h1 class="text-center">Quản lý shipper</h1>
            <div class="row">
                <div class="table-responsive table-hover">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="input-group input-group-outline my-3">
                                        <label class="form-label">Nhập thông tin shipper cần tìm</label>
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
                        <table class="table table-striped table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th>Hình đại diện<i class="fa fa-sort"></i></th>
                                    <th>Tên <i class="fa fa-sort"></i></th>
                                    <th>Số xe <i class="fa fa-sort"></i></th>
                                    <th>Quyền</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${shipperList}" var="shipper">
                                    <tr>                                     
                                        <td>${shipper.avatarShipper}</td>
                                        <td>Name</td>
                                        <td>${shipper.licensePlate}</td>

                                        <td>
                                            <a href="" class="view"color:#03A9F4; title="Xem chi tiết" data-toggle="tooltip"><i style="color:#03A9F4;" class="material-icons">&#xE417;</i></a>
                                            <a href="" class="edit" title="Sửa" data-toggle="tooltip"><i class="material-icons" style="color:#0d376f ;" >&#xE254;</i></a>
                                            <a href="" class="delete" title="Xoá" data-toggle="tooltip"><i class="material-icons" style="color:#E34724 ;" >&#xE872;</i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
