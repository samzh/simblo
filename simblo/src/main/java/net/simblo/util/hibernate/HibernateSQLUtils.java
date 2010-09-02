package net.simblo.util.hibernate;

import java.util.Iterator;

import net.simblo.base.controller.ParamsTable;
import net.simblo.util.StringUtil;

/**
 * The base hibernate sql utility.
 */
public class HibernateSQLUtils {

	/**
	 * Create the where statement.
	 * 
	 * @param classname
	 *            String
	 * @param params
	 *            Object
	 * @return The where statement.
	 * @see cn.myapps.base.dao.SQLUtils#createWhere(java.lang.String,
	 *      java.lang.Object)
	 */
	public String createWhere(String classname, Object params) {

		// If the paramter is null, return the "";
		if (params == null)
			return "";

		// If system cann't find the class, return the "";
		try {
			Class.forName(classname);
		} catch (Exception ex) {
			return "";
		}

		return createWhere((ParamsTable) params);
	}

	/**
	 * Create the where statement.
	 * 
	 * @param params
	 *            The parameter table
	 * @return The where statement.
	 */
	@SuppressWarnings("unchecked")
	public String createWhere(ParamsTable params) {
		// If the paramter is null, return the "";
		if (params == null)
			return "";

		Iterator<String> iter = params.keySet().iterator();
		String cndtn = "";

		while (iter.hasNext()) {
			String prmn = (String) iter.next();
			String paramsValue = (String) params.getParameter(prmn);
			int st = prmn.indexOf("_");

			if (st > 0 && paramsValue != null && paramsValue.length() > 0) {
				String fieldname = prmn.substring(st + 1).toLowerCase();

				if (prmn.toLowerCase().startsWith("san_")) {
					cndtn += fieldname + " <> '' and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("sxn_")) {
					cndtn += fieldname + " != '' and ";
					continue;
				}
				// 非零
				if (prmn.toLowerCase().startsWith("inz_")) {
					cndtn += fieldname + " <> 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("lnz_")) {
					cndtn += fieldname + " <> 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("dnz_")) {
					cndtn += fieldname + " <> 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("cnz_")) {
					cndtn += fieldname + " <> 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("snz_")) {
					cndtn += fieldname + " <> ' and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("fnz_")) {
					cndtn += fieldname + " <> 0 and ";
					continue;
				}
				// 正数
				if (prmn.toLowerCase().startsWith("ip_")) {
					cndtn += fieldname + " > 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("lp_")) {
					cndtn += fieldname + " > 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("dp_")) {
					cndtn += fieldname + " > 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("cp_")) {
					cndtn += fieldname + " > 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("fp_")) {
					cndtn += fieldname + " > 0 and ";
					continue;
				}
				// 负数
				if (prmn.toLowerCase().startsWith("in_")) {
					cndtn += fieldname + " < 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("ln_")) {
					cndtn += fieldname + " < 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("dn_")) {
					cndtn += fieldname + " < 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("cn_")) {
					cndtn += fieldname + " < 0 and ";
					continue;
				}
				if (prmn.toLowerCase().startsWith("fn_")) {
					cndtn += fieldname + " < 0 and ";
					continue;
				}

				String[] vallist = null;
				try {
					vallist = StringUtil.split(paramsValue, "|");
				} catch (Exception ex) {
				}
				String val = "";

				cndtn += " ( ";
				for (int j = 0; j < vallist.length; j++) {
					val = vallist[j];
					// 等于
					if (prmn.toLowerCase().startsWith("n_") && val.length() > 0) {
						cndtn += fieldname + " = " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("i_") && val.length() > 0) {
						cndtn += fieldname + " = " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("l_") && val.length() > 0) {
						cndtn += fieldname + " = " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("d_") && val.length() > 0) {
						// cndtn += fieldname + " = '" + val + "' or ";
						cndtn += fieldname + " = TO_DATE('" + val + "', 'yyyy-mm-dd') or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("c_") && val.length() > 0) {
						cndtn += fieldname + " = " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("s_") && val.length() > 0) {
						cndtn += fieldname + " like '" + val + "' or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("f_") && val.length() > 0) {
						cndtn += fieldname + " = " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("t_") && val.length() > 0) {
						cndtn += fieldname + " = '" + val + "' or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("b_") && val.length() > 0) {
						cndtn += fieldname + " = '" + val + "' or ";
						continue;
					}
					// 不等于
					if (prmn.toLowerCase().startsWith("xi_") && val.length() > 0) {
						cndtn += fieldname + " <> '" + val + "' or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("xl_") && val.length() > 0) {
						cndtn += fieldname + " <> " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("xn_") && val.length() > 0) {
						cndtn += fieldname + " <> " + val + " or ";
						continue;
					}

					// 大于
					if (prmn.toLowerCase().startsWith("ib_") && val.length() > 0) {
						cndtn += fieldname + " > " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("lb_") && val.length() > 0) {
						cndtn += fieldname + " > " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("db_") && val.length() > 0) {
						cndtn += fieldname + " > " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("cb_") && val.length() > 0) {
						cndtn += fieldname + " > " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("sb_") && val.length() > 0) {
						cndtn += fieldname + " > '" + val + "' or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("fb_") && val.length() > 0) {
						cndtn += fieldname + " > " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("tb_") && val.length() > 0) {
						cndtn += fieldname + " > '" + val + "' or ";
						continue;
					}
					// 小于
					if (prmn.toLowerCase().startsWith("is_") && val.length() > 0) {
						cndtn += fieldname + " < " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("ls_") && val.length() > 0) {
						cndtn += fieldname + " < " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("ds_") && val.length() > 0) {
						cndtn += fieldname + " < " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("cs_") && val.length() > 0) {
						cndtn += fieldname + " < " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("ss_") && val.length() > 0) {
						cndtn += fieldname + " < '" + val + "' or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("fs_") && val.length() > 0) {
						cndtn += fieldname + " < " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("ts_") && val.length() > 0) {
						cndtn += fieldname + " < '" + val + "' or "; // for
						// oracle
						continue;
					}
					// 大于等于
					if (prmn.toLowerCase().startsWith("ibe_") && val.length() > 0) {
						cndtn += fieldname + " >= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("lbe_") && val.length() > 0) {
						cndtn += fieldname + " >= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("dbe_") && val.length() > 0) {
						cndtn += fieldname + " >= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("cbe_") && val.length() > 0) {
						cndtn += fieldname + " >= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("sbe_") && val.length() > 0) {
						cndtn += fieldname + " >= '" + val + "' or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("mbe_") && val.length() > 0) {
						cndtn += fieldname + " >= '" + val.substring(0, 10) + " " + val.substring(10, val.length())
								+ "' or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("fbe_") && val.length() > 0) {
						cndtn += fieldname + " >= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("tbe_") && val.length() > 0) {
						cndtn += fieldname + " >= '" + val + "' or ";
						continue;
					}
					// 小于等于
					if (prmn.toLowerCase().startsWith("ise_") && val.length() > 0) {
						cndtn += fieldname + " <= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("lse_") && val.length() > 0) {
						cndtn += fieldname + " <= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("dse_") && val.length() > 0) {
						cndtn += fieldname + " <= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("cse_") && val.length() > 0) {
						cndtn += fieldname + " <= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("sse_") && val.length() > 0) {
						cndtn += fieldname + " <= '" + val + "' or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("mse_") && val.length() > 0) {
						cndtn += fieldname + " <= '" + val.substring(0, 10) + " " + val.substring(10, val.length())
								+ "' or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("fse_") && val.length() > 0) {
						cndtn += fieldname + " <= " + val + " or ";
						continue;
					}
					if (prmn.toLowerCase().startsWith("tse_") && val.length() > 0) {
						cndtn += fieldname + " <= '" + val + "' or ";
						continue;
					}
					// 模糊
					if (prmn.toLowerCase().startsWith("sm_") && val.length() > 0) {
						cndtn += fieldname + " like '%" + val + "%' or ";
						continue;
					}
				}
				cndtn = cndtn.endsWith("or ") ? cndtn.substring(0, cndtn.length() - 3) + " ) and " : cndtn;
				cndtn = cndtn.trim().endsWith("(") ? "" : cndtn;
			}
		}

		cndtn = cndtn.endsWith("and ") ? cndtn.substring(0, cndtn.length() - 4) : cndtn;
		System.out.println(cndtn);
		return cndtn;
	}

}
