package net.simblo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class PageTag extends TagSupport {
	/**
	 * 当前页
	 */
	private String curPage;
	/**
	 * 总页数
	 */
	private String totalPage;
	/**
	 * 页大小(一页显示的大小)
	 */
	private String pageSize;

	/**
	 * 总条数
	 */
	private String totalCount;

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		if (pageSize == null || pageSize == "") {
			pageSize = "5";
		}

		if (totalCount == null || totalCount == "") {
			totalCount = "0";
		}

		int pages = (Integer.parseInt(totalCount) / Integer.parseInt(pageSize)) + 1;
		if (Integer.parseInt(curPage) >= pages) {
			curPage = String.valueOf(pages);
		}
		if (Integer.parseInt(curPage) < 1) {
			curPage = "1";
		}
		// 显示给用户操作的页面开始端
		int start = Integer.parseInt(curPage) - 4;
		// 显示给用户操作的页面结束端
		int end = Integer.parseInt(curPage) + 4;
		// 特殊情况处理(开始端小于0)
		if ((Integer.parseInt(curPage) - 4) <= 0) {
			start = 1;
		}
		// 特殊情况处理(结束端大于总页数)
		if ((Integer.parseInt(curPage) + 4) > pages) {
			end = pages;
		}
		try {
			out.print("<form action='index'>");
			out.print("<a href='index?curpage=1'>[首页]</a>  ");
			if (Integer.parseInt(curPage) - 1 >= 0) {
				out.print("<a href='index?curpage="
						+ (((Integer.parseInt(curPage) - 1) == 0) ? curPage : ((Integer.parseInt(curPage) - 1))
								+ "'>[上一页]</a>"));
			}

			for (int i = start; i <= end; i++) {
				if (i != Integer.parseInt(curPage)) {
					out.print("<a href='index?curpage=" + i + "'>[" + i + "]</a>  ");
				} else {
					out.print("<b>" + i + "</b>  ");
				}

			}

			if (Integer.parseInt(curPage) + 1 <= pages) {
				out.print("<a href='index?curpage="
						+ (((Integer.parseInt(curPage) + 1) > pages) ? curPage : ((Integer.parseInt(curPage) + 1))
								+ "'>[下一页]</a> "));
			}

			out.print(" <a href='index?curpage=" + pages + "'>[末页]</a>");
			out.print("<input name='curpage' style='width:22px;height:22px;' /><input type=submit value=go /></form>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalCount() {
		return totalCount;
	}
}
