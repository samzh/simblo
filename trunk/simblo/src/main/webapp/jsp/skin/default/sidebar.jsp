<div id="sidebar">
		<ul>
			
			<!-- you can edit here for yousself -->
			<li><h2><?php _e('Meta') ?></h2>
				<ul>
					<?php wp_register(); ?>
					<li><?php wp_loginout(); ?></li>
					<li><a href="http://moierby.com/about" title="关于莫矮水北">关于<abbr title="莫矮水北-moierby">莫矮水北</abbr></a></li>
					<li><a href="http://moierby.com/guestbook" title="留言本">留言本</a></li>
					<li><a href="http://moierby.com/sitemap" title="网站地图">网站地图</a></li>
					<?php wp_meta(); ?>
				</ul>
			</li>

			<?php if ( !function_exists('dynamic_sidebar') || !dynamic_sidebar() ) : ?>

			<!-- Author information is disabled per default. Uncomment and fill in your details if you want to use it.
			<li><h2><?php _e('Author') ?></h2>
			<p>A little something about you, the author. Nothing lengthy, just an overview.</p>
			</li>
			-->
			<!--
			<?php wp_list_pages('title_li=<h2>'.__('Pages').'</h2>' ); ?>
			-->
			<li><h2><?php _e('Categories') ?></h2>
				<ul>
				<?php wp_list_categories('orderby=name&title_li='); ?>
				</ul>
			</li>

			<li><h2><?php _e('Archives') ?></h2>
				<ul>
				<?php wp_get_archives('type=monthly'); ?>
				</ul>
			</li>

			<?php /* If this is the frontpage */ if ( is_home() || is_page() ) { ?>				
				<?php get_links_list(); ?>
				
				
			<?php } ?>

			<?php endif; ?>
		</ul>
	</div>