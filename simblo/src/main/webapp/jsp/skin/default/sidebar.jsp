<div id="sidebar">
<ul>

	<!-- you can edit here for yousself -->
	<li>
	<h2>Meta</h2>
	<ul>
		<li>Log out</li>
		<li><a href="<c:url value='/about'/>" title="About">About</a></li>
		<li><a href="<c:url value='/'/>" title="Message">Message</a></li>
		<li><a href="<c:url value='/sitemap' />" title="Sitemap">Sitemap</a></li>
	</ul>
	</li>

	<li>
	<h2>Categories</h2>
	<c:if test="${fn:length(categoryList) > 0 }">
		<ul>
			<c:forEach items="${categoryList}" var="category">
				<li>${category.name}</li>
			</c:forEach>
		</ul>
	</c:if></li>

	<li>
	<h2>Archives</h2>
	<ul>
		<li>1</li>
		<li>2</li>
		<li>3</li>
		<li>4</li>
		<li>5</li>
		<li>6</li>
		<li>7</li>
		<li>8</li>
	</ul>
	</li>
</ul>
</div>