<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<!--Start of Tawk.to Script-->
<script type="text/javascript">
	var Tawk_API = Tawk_API || {}, Tawk_LoadStart = new Date();
	(function() {
		var s1 = document.createElement("script"), s0 = document
				.getElementsByTagName("script")[0];
		s1.async = true;
		s1.src = 'https://embed.tawk.to/601a48f5c31c9117cb7549f9/1etjapvth';
		s1.charset = 'UTF-8';
		s1.setAttribute('crossorigin', '*');
		s0.parentNode.insertBefore(s1, s0);
	})();
</script>
<!--End of Tawk.to Script-->


<div id="cateList">
	<table>
		<tr>
			<c:forEach items="${CategoryList}" var="categoryVO">
				<c:choose>
					<c:when test="${categoryVO.cateName eq 'none'}">
						<th style="display: none;">none</th>
					</c:when>
					<c:otherwise>
						<th><a href="MypetServlet?command=${categoryVO.cateName}">
								<img src="images/category/${categoryVO.cateName}_index.JPG" />
						</a></th>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</table>
</div>


<div class="clear"></div>


<%@ include file="../include/footer.jsp"%>
