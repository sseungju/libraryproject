<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${LibraryInfo.name ne null }">
<h3>${LibraryInfo.name}</h3>
	<div class="btnClose" onclick="FeatureInfoWndClose();"></div>
	<hr>
	<table>
		<tr>
			<th>전화번호</th>
			<td class="phone">${LibraryInfo.phone}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td class="address">${LibraryInfo.address}</td>
		</tr>
		<tr>
			<th>휴관일</th>
			<td class="closed">${LibraryInfo.closed}</td>
		</tr>
		<tr>
			<th>유형</th>
			<td class="type">${LibraryInfo.type}</td>
		</tr>		
		<tr>
			<th>자료</th>
			<td class="data">대출권수 : ${LibraryInfo.borrowbook}(권), 대출일수 : ${LibraryInfo.borrowdate}(일), 책이음상태 : ${LibraryInfo.libraryone}</td>
		</tr>	
		<tr>
			<th>열람좌석수</th>
			<td class="seat">${LibraryInfo.seat}</td>
		</tr>
	</table>
</c:if>