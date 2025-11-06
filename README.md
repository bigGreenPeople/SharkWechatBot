# WeChatXposedControl 协议文档


## 免费使用
项目目前处于开发阶段联系本人获取激活码

## 项目概述

WeChatXposedControl 是一个基于 Xposed 框架的 Android 模块，用于微信（WeChat）的行为控制和自定义。该模块通过 MQTT 协议与服务端通信，实现消息发送/接收、好友管理、朋友圈操作等功能。模块支持微信 8.x+ 版本，适用于 Root 设备（Magisk + LSPosed 推荐）。


<img src="https://github.com/bigGreenPeople/SharkWechatBot/blob/main/%E6%9C%AA%E6%BF%80%E6%B4%BB.png?raw=true" width="150" alt="已激活"/>
<img src="https://github.com/bigGreenPeople/SharkWechatBot/blob/main/%E5%B7%B2%E6%BF%80%E6%B4%BB.png?raw=true" width="150" alt="已激活"/>


**警告：** 本模块仅供学习和研究使用。请遵守微信服务条款和法律法规。使用前备份数据，可能导致账号风险或应用崩溃。

## 联系与支持

- 作者： [[bigGreenPeople]](https://github.com/bigGreenPeople)
- QQ：1243596620
- Telegram (TG)：[@SpiderMonke7](https://t.me/SpiderMonke7)
- Email： [1243596620@qq.com]

## 系统要求

- Android 10.0+
- Xposed/EdXposed/LSPosed 框架
- Root 权限
- 微信 8.0+
- MQTT Broker（服务端）

## 安装与配置

1. 安装 Xposed 框架并激活模块。
2. 重启微信，模块自动订阅主题。
3. 服务端通过公共/私有主题发送命令。


## 通信协议

模块使用 MQTT 协议与服务端通信。消息格式为 JSON，使用 `MqRequestModel<T>` (微信 → 服务端) 和 `MqResponseModel<T>` (服务端 → 微信)。

### MQTT 主题

- **公共发布 (服务端 → 所有微信)**: `wx_message_send_public`
- **公共订阅 (所有微信 → 服务端)**: `wx_message_rev_public`
- **私有发布 (服务端 → 特定微信)**: `wx_message{wid}` , `wx_messagewxid_*************`)
- **私有订阅 (特定微信 → 服务端)**: `wx_message{wid}` , `wx_message_revwxid_*************`)

**示例**: 向 `wxid_*************` 发送消息，使用 `wx_messagewxid_*************`。

### 通信模型

#### MqResponseModel<T> (服务端推送)
```java
public class MqResponseModel<T> {
    private int type;      // 请求类型 (ResponseType)
    private String wechatId; // 微信 ID (可为 null，表示公共)
    private T data;        // 数据 (优先 String)
}
```

#### MqRequestModel<T> (微信推送)
```java
public class MqRequestModel<T> {
    private int type;      // 请求类型 (RequestType)
    private String wechatId; // 微信 ID
    private T data;        // 数据 (优先 String)
}
```

### 服务端信息类型 (ResponseType)

| 类型 | 描述 | 值 |
|------|------|----|
| SEND_TEXT | 发送文本 | 2000 |
| SEND_IMG | 发送图片 | 2001 |
| SEND_VIDEO | 发送视频 | 2002 |
| SEND_REPLY | 发送引用消息 | 2003 |
| SEND_CARD | 发送卡片 | 2007 |
| SEND_VOICE | 发送语音 | 2008 |
| SEND_LOCATION | 发送位置 | 2009 |
| SEND_EMOJI_GIF | 获取表情包 GIF | 2010 |
| FRIEND_AGREE | 同意好友请求 | 2101 |
| FRIEND_ADD | 主动添加好友 | 2102 |
| FRIEND_SEARCH | 搜索好友 | 2103 |
| CONTACT_LIST | 获取联系人列表 | 2201 |
| SESSION_LIST | 获取会话列表 | 2301 |
| HISTORY_MSG | 获取历史消息 | 2401 |
| USER_INFO | 获取登录用户 | 2500 |
| GET_IMG | 获取消息大图 | 2005 |
| GET_VIDEO | 获取消息视频 | 2006 |
| GET_SNS_LIST | 获取朋友圈列表 | 2801 |
| SYNC_SNS | 同步朋友圈 | 2802 |
| SNS_LIKE | 朋友圈点赞 | 2803 |
| SNS_COMMENT | 朋友圈评论 | 2804 |
| SNS_UNLIKE | 朋友圈取消点赞 | 2805 |
| SNS_POST_TEXT | 发送文字朋友圈 | 2806 |
| SNS_POST_MEDIA | 发送图文朋友圈 | 2807 |
| GET_SNS_PAGINATED | 获取朋友圈分页 | 2808 |
| GET_SNS_SINGLE | 获取单条朋友圈 | 2809 |
| TEST | 测试 | 0 |

### 微信信息类型 (RequestType)

| 类型 | 描述 | 值 |
|------|------|----|
| WX_LOGIN | 微信上线 | 5000 |
| REV_TEXT | 接收文本 | 1000 |
| REV_IMG | 接收图片 | 1001 |
| REV_VIDEO | 接收视频 | 1002 |
| REV_REPLY | 接收引用消息 | 1004 |
| REV_VOICE | 接收语音 | 1003 |
| REV_CARD | 接收卡片 | 1009 |
| REV_LOCATION | 接收位置 | 1012 |
| REV_UNKNOWN | 接收未知消息 | 1011 |
| REV_EMOJI | 接收表情包 | 1008 |
| FRIEND_REQUEST | 好友请求 | 1100 |
| FRIEND_AGREE | 好友同意 | 1101 |
| FRIEND_REPLY | 好友回复 | 1103 |
| CONTACT_REPLY | 联系人列表回复 | 1201 |
| FRIEND_CHANGE | 好友变化 | 1106 |
| GET_IMG_REPLY | 大图回复 | 1005 |
| GET_VIDEO_REPLY | 视频回复 | 1006 |
| GET_EMOJI_GIF | 表情包 GIF 回复 | 10100 |
| SNS_REPLY | 朋友圈回复 | 1801 |
| SNS_SYNC_REPLY | 朋友圈同步回复 | 1802 |
| SNS_LIKE_REPLY | 点赞回复 | 1803 |
| SNS_COMMENT_REPLY | 评论回复 | 1804 |
| SNS_POST_REPLY | 发圈回复 | 1806 |
| SNS_PAGINATED_REPLY | 分页回复 | 1808 |
| SNS_SINGLE_REPLY | 单条回复 | 1809 |

## 服务端调用微信功能

### 发送消息/表情
```json
{
  "type": 2000,
  "data": {
    "message": "吃飯了嘛",
    "sendWechatId": "wxid_*************",
    "revWechatId": "wxid_*************"
  }
}
```
- 表情: 使用 `[表情名称]` , `[发呆]`)。参考微信版本表情列表。

### 发送引用消息
```json
{
  "type": 2003,
  "data": {
    "replyMessage": "回复了嘛",
    "revWechatId": "wxid_*************",
    "wxMessageJson": "{...}"  // 被引用消息 JSON 字符串
  }
}
```
- `wxMessageJson`: 完整消息 JSON (包含 `content`、`msgSvrId` 等)。

### 发送卡片
```json
{
  "type": 2007,
  "data": {
    "title": "【限时1.9元】老板必学的AI商业课1",
    "description": "线上试听版",
    "wechatId": "wxid_*************",
    "content": "<msg>...</msg>"  // XML 内容 (title/desc 与 content 保持一致)
  }
}
```

### 发送图片
```json
{
  "id": "123456789",
  "type": 2001,
  "data": {
    "wechatId": "wxid_*************",
    "imgUrlList": [
      "https://tatic.com/avatar/1047/96/0403fb27c64440fbbfd6499c34cb65_180_135.jpg?1752655810"
    ]
  }
}
```

### 发送位置
```json
{
  "type": 2009,
  "data": {
    "content": "> <msg> <location x=\"380.281595\" y=\"1136.203606\" scale=\"9\" label=\"宿松县沪渝高速\" maptype=\"0\" poiname=\"宿松县河塌乡管家冲\" poiid=\"nearby_10437007370943504582\" buildingId=\"\" floorName=\"\" poiCategoryTips=\"\" poiBusinessHour=\"\" poiPhone=\"\" poiPriceTips=\"0.0\" isFromPoiList=\"false\" adcode=\"\" cityname=\"\" /> </msg> ",
    "revWechatId": "wxid_*************"
  }
}
```

### 发送语音
```json
{
  "id": "123456789",
  "type": 2008,
  "data": {
    "wechatId": "wxid_*************",
    "voiceUrl": "https://erclone.com:9090/tenant-0/wechat/voice/0/1756216707944_msg_312158082625192cf8140b3101.amr",
    "duration": "3000"
  }
}
```

### 同意好友添加
```json
{
  "type": 2101,
  "data": {
    "requestMessage": "<msg>...</msg>",  // 好友申请 XML
    "wechatId": "wxid_*************",
    "scene": "17"  // 添加渠道 , 17: 名片, 30: 扫码)
  }
}
```

### 搜索好友
```json
{
  "id": "12354",
  "type": 2103,
  "data": {
    "searchKey": "*********"  // 手机号/名称
  }
}
```
- 回复: 包含 `user`、`nick`、`alias` 等。

### 主动添加好友
```json
{
  "type": 2102,
  "data": {
    "addSig": "v3_020b3826fd0301000000000088c04564564650000501ea9a3dba12f95f6b60a0536a1adb60204f14564654894879879878978d3c55c0578845a693116d2ce464@stranger",
    "message": "你好"
  }
}
```

### 获取联系人/会话列表
```json
{
  "type": 2201,  // 或 2301
  "data": {
    "startTime": "1733904131",  // 可选
    "endTime": "1733904132"     // 可选
  }
}
```
- 回复: 数组，包含 `username`、`nickname`、`alias`、`sex`、`headImg`、`phone` 等。

### 获取历史消息
```json
{
  "type": 2401,
  "data": {
    "talker": "wxid_*************",
    "startTime": "1749658756949",
    "endTime": "1749826094000"
  }
}
```
- 回复: 数组，包含 `content`、`createTime`、`isSend`、`type`、`lvbuffer` 等。

### 获取登录用户信息
```json
{
  "type": 2500,
  "data": {}
}
```
- 回复: 包含 `loginWeixinUsername`、`lastLoginNickName` 等。

### 获取消息大图/视频/GIF
- 大图: `type: 2005`, `data: {msgSvrId: "...", msgId: "..."}`
- 视频: `type: 2006`, `data: {msgId: "...", imgPath: "..."}`
- GIF: `type: 2010`, `data: {md5: "..."}`
- 回复: URL , `https://.../image/...` 或 `/mp4/...` 或 `/emoji_animation.gif`)。

### 朋友圈操作

#### 获取朋友圈列表 (时间范围，注意跨度小)
```json
{
  "type": 2801,
  "data": {
    "userName": "wxid_*************",  // 可选
    "startTime": "1754469517",
    "endTime": "1754555917"
  }
}
```
- 回复: 数组，包含 `snsId`、`contentDesc`、`mediaUrlList`、`snsObject` (点赞/评论) 等。

#### 同步朋友圈 / 分页 / 单条
- 同步: `type: 2802`
- 分页: `type: 2808`, `data: {snsId: "-3707261564527312320"}` (起始 ID, 首页 0)
- 单条: `type: 2809`, `data: {snsId: "..."}`

#### 点赞/取消/评论
```json
{
  "type": 2803,  // 点赞
  "data": {
    "snsId": "-3707261564527312320",
    "username": "wxid_*************"
  }
}
```
- 取消: `type: 2805`, `data: {snsId: "..."}`
- 评论: `type: 2804`, `data: {snsId: "...", username: "...", commentMsg: "你好", commentId: "...", commentWid: "..."}` (回复评论时填)。

#### 发送朋友圈
- 文字: `type: 2806`, `data: {snsMessage: "今天非常开心"}`
- 图文: `type: 2807`, `data: {imgUrlList: [...], callUsers: [...], wbList: [...], isBlack: "1", snsMessage: "..."}`
- 位置: 在回复的 `location` 中指定 (从获取朋友圈复制)。

## 微信通知服务端

### 上线/心跳
- 上线: `type: 5000`, `data: {loginWeixinUsername: "...", lastLoginNickName: "..."}`
- 心跳: `type: 0` (每 10s)

### 接收消息
- 文本: `type: 1000`, `data: {content: "...", talker: "...", isSend: 0}`
- 图片: `type: 1001`, `data: {imgPath: "...", imgUrl: "..."}`
- 视频: `type: 1002`, `data: {imgPath: "...", imgUrl: "..."}` (缩略图)
- 语音: `type: 1003`, `data: {imgUrl: ".../voice/...amr"}`
- 引用: `type: 1004`, `data: {content: XML with refermsg}`
- 卡片: `type: 1009`, `data: {content: XML with url/title}`
- 位置: `type: 1012`, `data: {content: XML with x/y/label}`
- 表情包: `type: 1008`, `data: {imgPath: MD5, imgUrl: "..."}`
- 未知: `type: 1011`

### 好友事件
- 请求: `type: 1100`, `data: XML (fromusername, content 等)`
- 同意: `type: 1101`, `data: XML`
- 变化: `type: 1106`, `data: {changeType: "FIRST_ADD/DELETE/RE_ADD", contact: {...}}`

### 其他回复
- 联系人: `type: 1201`
- 朋友圈: `type: 1801/1802/1808/1809` (详见上)

## 已知问题

- 微信更新可能导致钩子失效，需适配。
- 大文件传输 (视频/语音) 需解码 , SILK_V3 for AMR)。
- 朋友圈查询时间跨度勿过大，避免卡顿。
