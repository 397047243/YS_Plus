<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					APP 信息管理维护 <i class="fa fa-user"></i><small>${devUserSession.devName}
						- 您可以通过搜索或者其他的筛选项对APP的信息进行修改、删除等管理操作。^_^</small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<form method="post" action="${pageContext.request.contextPath}/dev/maintain">
					<input type="hidden" name="pageIndex" value="1" />
			    <ul>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input name="softwareName"  id="appName" type="text" class="form-control col-md-7 col-xs-12" value="${appinfo.softwareName}">
							</div>
						</div>
					</li>
					
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="status" id="appstatus" class="form-control">
									<c:if test="${statuslist != null }">
									   <option value="">--请选择--</option>
									   <c:forEach var="dataDictionary" items="${statuslist}">
									   		<option <c:if test="${dataDictionary.valueId == appinfo.status }">selected="selected"</c:if>
									   		value="${dataDictionary.valueId}">${dataDictionary.valueName}</option>
									   </c:forEach>
									</c:if>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="flatformId" id="flatformId" class="form-control">
									<c:if test="${flatformIdlist != null }">
									   <option value="">--请选择--</option>
									   <c:forEach var="dataDictionary" items="${flatformIdlist}">
									   		<option <c:if test="${dataDictionary.valueId == appinfo.flatformId }">selected="selected"</c:if>
									   		value="${dataDictionary.valueId}">${dataDictionary.valueName}</option>
									   </c:forEach>
									</c:if>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="queryCategoryLevel1" name="categoryLevel1" class="form-control">
									<c:if test="${categoryLevel1List != null }">
									   <option value="">--请选择--</option>
									   <c:forEach var="appCategory" items="${categoryLevel1List}">
									   		<option <c:if test="${appCategory.id == appinfo.categoryLevel1 }">selected="selected"</c:if>
									   		value="${appCategory.id}">${appCategory.categoryName}</option>
									   </c:forEach>
									</c:if>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
        						<select name="categoryLevel2" id="queryCategoryLevel2" class="form-control">
        							<c:if test="${categoryLevel2List != null }">
									   <option value="">--请选择--</option>
									   <c:forEach var="appCategory" items="${categoryLevel2List}">
									   		<option <c:if test="${appCategory.id == appinfo.categoryLevel2 }">selected="selected"</c:if>
									   		value="${appCategory.id}">${appCategory.categoryName}</option>
									   </c:forEach>
									</c:if>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
        						<select name="categoryLevel3" id="queryCategoryLevel3" class="form-control">
        							<c:if test="${categoryLevel3List != null }">
									   <option value="">--请选择--</option>
									   <c:forEach var="appCategory" items="${categoryLevel3List}">
									   		<option <c:if test="${appCategory.id == appinfo.categoryLevel3 }">selected="selected"</c:if>
									   		value="${appCategory.id}">${appCategory.categoryName}</option>
									   </c:forEach>
									</c:if>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询 </button>
						<button type="button" id="rset" class="btn btn-default"> 重 &nbsp;&nbsp;&nbsp;&nbsp;填 </button>
					</li>
				</ul>
			</form>
		</div>
	</div>
</div>
<div class="col-md-12 col-sm-12 col-xs-12">
	<div class="x_panel">
		<div class="x_content">
			<p class="text-muted font-13 m-b-30"></p>
			<div id="datatable-responsive_wrapper"
				class="dataTables_wrapper form-inline dt-bootstrap no-footer">
				<div class="row">
					<div class="col-sm-12">
					<a href="${pageContext.request.contextPath}/dev/appinfoadd" class="btn btn-success btn-sm">新增APP基础信息</a>
						<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
							cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="First name: activate to sort column descending"
										aria-sort="ascending">软件名称</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										APK名称</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										软件大小(单位:M)</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										所属平台</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										所属分类(一级分类、二级分类、三级分类)</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										状态</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										下载次数</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										最新版本号</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 124px;"
										aria-label="Last name: activate to sort column ascending">
										操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="appinfo_" items="${appinfolist}" varStatus="status">
									<tr role="row" class="odd">
										<td tabindex="0" class="sorting_1">${appinfo_.softwareName}</td>
										<td>${appinfo_.APKName}</td>
										<td>${appinfo_.softwareSize}</td>
										<td>${appinfo_.flatformName }</td>
										<td>${appinfo_.categoryLevel1Name} -> ${appinfo_.categoryLevel2Name} -> ${appinfo_.categoryLevel3Name}</td>
										<td><span id="appInfoStatus${appinfo_.id}">${appinfo_.statusName }</span></td>
										<td>${appinfo_.downloads }</td>
										<td>${appinfo_.versionNo }</td>
										<td>

										<div class="btn-group">
                      <button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" aria-expanded="false">
						  点击操作
						  <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                      </button>
                      <ul class="dropdown-menu" role="menu">
                        <li>
                        	<c:choose>
											<c:when test="${appinfo_.status == 2 || appinfo_.status == 5}">
												<a class="saleSwichOpen" status="4" saleSwitch="open" appinfoid=${appinfo_.id }  appsoftwarename=${appinfo_.softwareName } data-toggle="tooltip" data-placement="top" >上架</a>
											</c:when>
											<c:when test="${appinfo_.status == 4}">
												<a class="saleSwichClose" saleSwitch="close" status="5" appinfoid=${appinfo_.id }  appsoftwarename=${appinfo_.softwareName } data-toggle="tooltip" data-placement="top" >下架</a>
											</c:when>
										</c:choose>
                        </li>
                        <li><a class="addVersion" appinfoid="${appinfo_.id }" data-toggle="tooltip" data-placement="top" >新增版本</a>
                        </li>
                        <li><a class="modifyVersion"
											appinfoid="${appinfo_.id }" versionid="${appinfo_.versionId }" status="${appinfo_.status }"
											statusname="${appinfo_.statusName }"
											data-toggle="tooltip" data-placement="top" >修改版本</a>
                        </li>
                        <li><a  class="modifyappinfo_"
											appinfoid="${appinfo_.id }" status="${appinfo_.status }" statusname="${appinfo_.statusName }"
											data-toggle="tooltip" data-placement="top" >修改</a></li>
                        <li><a  class="viewApp" href="${pageContext.request.contextPath }/dev/appview/${appinfo_.id }"  data-toggle="tooltip" data-placement="top" >查看</a></li>
						<li><a  class="deleteApp" appinfo_id=${appinfo_.id }  appsoftwarename=${appinfo_.softwareName } data-toggle="tooltip" data-placement="top" >删除</a></li>
                      </ul>
                    </div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<c:if test="${totalCount > 0}">
					<div class="row">
						<div class="col-sm-5">
							<div class="dataTables_info" id="datatable-responsive_info"
								 role="status" aria-live="polite">共${totalCount}条记录
									${currentPageNo}/${totalPageCount}页</div>
						</div>
						<div class="col-sm-7">
							<div id="page_" index="${currentPageNo}">
								<ul>
									<li class="prev" val="${isPrev}">上一页</li>
									<c:forEach varStatus="sta" begin="1" end="${totalPageCount}" step="1">
										<li class="pNum" val="${sta.count}">${sta.count}</li>
									</c:forEach>
									<li class="next" val="${isNext}">下一页</li>
								</ul>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${totalCount < 1}">
					<p>暂无数据</p>
				</c:if>
			</div>

		</div>
	</div>
</div>
</div>
<%@include file="common/footer.jsp"%>
<%--<script src="${pageContext.request.contextPath }/statics/localjs/jquery-1.8.3.min.js"></script>--%>
<script>
    $(function(){
        var Bindex = $("#page_").attr("index");
        console.log(Bindex)
        console.log($(".pNum").eq(Bindex-1))
        $(".pNum").eq(Bindex-1).css({
            color:"#fff",
            backgroundColor: "#0c89de"
        });

        $(".prev").click(function(){ //上一页
            if($(this).attr("val") == "true"){
                var index = $("#page_").attr("index");
                location.href = "maintain?pageIndex="+(--index);
            }else{
                alert("没有上一页哦！");
            }
        });

        $(".next").click(function(){ //下一页
            if($(this).attr("val") == "true"){
                var index = $("#page_").attr("index");
                location.href = "maintain?pageIndex="+(++index);
            }else{
                alert("没有下一页哦！");
            }
        });

        $(".pNum").click(function(){
            var index = $(this).attr("val");
            location.href = "maintain?pageIndex="+index;
        });

    });
</script>
<script src="${pageContext.request.contextPath }/statics/localjs/appinfolist.js"></script>