package cc.ruit.shunjianmei.net.request;

import cc.ruit.shunjianmei.base.BaseRequest;

import com.google.gson.GsonBuilder;
import com.lidroid.xutils.util.LogUtils;
import com.oruit.oruitkey.OruitKey;

/**
 * @ClassName: StoreListRequest
 * @Description: 商户列表
 * @author: gaoj
 * @date: 2015年10月14日 下午4:41:29
 */
public class StoreListRequest extends BaseRequest {
	private String UserID;//用户ID
	private String CityID;//城市ID
	private String Score;//店铺评论星级 默认1从高到低 0从低到高
	private String Order;//订单 默认1从多到少 0从少到多
	private String Longitude;//经度
	private String Latitude;//纬度
	private String Car;//车位数 默认1从多到少
	private String Type;//排序类型 1按星级2按订单3按距离（距离之后近到远）4按车位数
	private String PageIndex;//返回数据行数 
	private String PageSize;//当前页数 从1开始
	

	public StoreListRequest(String userID, String cityID, String score,
			String order, String longitude, String latitude, String car,String Type,
			String pageStart, String pageSize) {
		super("H_StoreList", "1.0");
		this.UserID = userID;
		this.CityID = cityID;
		this.Score = score;
		this.Order = order;
		this.Longitude = longitude;
		this.Latitude = latitude;
		this.Car = car;
		this.Type = Type;
		this.PageIndex = pageStart;
		this.PageSize = pageSize;
		String uid = System.currentTimeMillis() + userID;
		setUid(uid, OruitKey.encrypt(uid, "H_StoreList"));
	}

	/**
	 * @Title: toJsonString
	 * @Description:  把对象转成json格式的字符串
	 * @author: lee
	 * @param obj
	 * @return: String
	 */
	public String toJsonString(StoreListRequest obj) {
		GsonBuilder gson = new GsonBuilder();
		gson.disableHtmlEscaping();
		String json = gson.create().toJson(obj);
		LogUtils.i("cord==" + json);
		return json;
	}

	@Override
	public String toString() {
		return "StoreListRequest [UserID=" + UserID + ", CityID=" + CityID
				+ ", Score=" + Score + ", Order=" + Order + ", Longitude="
				+ Longitude + ", Latitude=" + Latitude + ", Car=" + Car
				+ ", Type=" + Type + ", PageIndex=" + PageIndex + ", PageSize="
				+ PageSize + ", Method=" + Method + ", Infversion="
				+ Infversion + ", Key=" + Key + ", UID=" + UID + "]";
	}

}
