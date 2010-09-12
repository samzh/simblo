<div id="content">
<c:choose>
	<c:when test="${fn:length(postList) > 0 }">
		<c:forEach items="${postList}" var="p">
			<div class="post" id="post-${p.id}">
			<h2 class="posttitle"><a href="#" rel="bookmark"
				title="Permanent Link to #">${p.title}</a></h2>
			<div class="postmetadata"><?php the_time(get_option('date_format').', '.get_option('time_format')) ?>
			<!-- <?php _e('by') ?> <?php the_author() ?> --></div>
			<div class="postentry"><?php the_content(__('Continue reading'). " &#8216;" . the_title('', '', false) . "&#8217; &raquo;"); ?>
			</div>

			<div class="postmetadata"></div>
			</div>
		</c:forEach>
		<div class="page_navi pro_next">
			<si:pagination totalPage="5" curPage="1" totalCount="${fn:length(postList)}" />
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