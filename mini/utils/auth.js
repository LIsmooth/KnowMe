const KM = require('./KMAPI.js')


async function register(page) {
    let _this = this;
    wx.login({
        success: function (res) {
            let code = res.code; // 微信登录接口返回的 code 参数，下面注册接口需要用到
            wx.getUserInfo({
                success: function (res) {
                    let iv = res.iv;
                    let encryptedData = res.encryptedData;
                    // 下面开始调用注册接口
                    KM.register_complex({
                        code: code,
                        encryptedData: encryptedData,
                        iv: iv,
                    }).then(function (res) {
                        console.log('this is register then');
                    })
                }
            })
        }
    })
}

async function login(page) {
    const _this = this
    wx.login({
        success: function (res) {
            KM.login_wx(res.code).then(function (res) {
                if (res.code == 10000) {
                    // 去注册
                    //_this.register(page)
                    return;
                }
                if (res.code != 0) {
                    // 登录错误
                    wx.showModal({
                        title: '无法登录',
                        content: res.msg,
                        showCancel: false
                    })
                    return;
                }
                wx.setStorageSync('token', res.data.token)
                wx.setStorageSync('uid', res.data.uid)
                if (page) {
                    page.onShow()
                }
            })
        }
    })
}

module.exports={
    register:register
}