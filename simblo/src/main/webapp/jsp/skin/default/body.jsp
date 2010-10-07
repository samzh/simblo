<div id="content">
<c:choose>
	<c:when test="${fn:length(postList) > 0 }">
		<c:forEach items="${postList}" var="p">
			<div class="post" id="post-${p.id}">
			<h2 class="posttitle"><a href="#" rel="bookmark"
				title="Permanent Link to #">${p.title}</a></h2>
			<div class="postmetadata">${p.updated }
			<!-- <?php _e('by') ?> <?php the_author() ?> --></div>
			<div class="postentry">
			</div>

			<div class="postmetadata">Tags:</div>
			</div>
		</c:forEach>
		<div class="page_navi pro_next">
			<si:pagination curPage="1" totalCount="${totalCount}" />
		</div>
	</c:when>
	<c:otherwise>
		<div class="post">
		<h2 class="posttitle">Not found</h2>
		<div class="postentry">
		<p>Sorry, no posts matched your criteria.</p>
		</div>
		</div>
	</c:otherwise>
</c:choose></div>