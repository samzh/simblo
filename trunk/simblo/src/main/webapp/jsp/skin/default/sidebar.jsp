<div id="sidebar">
<ul>

	<!-- you can edit here for yousself -->
	<li>
	<h2>Meta</h2>
	<ul>
		<li>注销</li>
		<li><a href="http://moierby.com/about" title="关于莫矮水北">关于<abbr
			title="莫矮水北-moierby">莫矮水北</abbr></a></li>
		<li><a href="http://moierby.com/guestbook" title="留言本">留言本</a></li>
		<li><a href="http://moierby.com/sitemap" title="网站地图">网站地图</a></li>
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