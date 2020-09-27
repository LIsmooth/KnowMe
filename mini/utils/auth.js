const KM = require('./KMAPI.js');

async function login() {
    wx.login({
        success: function (res) {
            KM.login_wx(res.code).then(function (res) {
                if (res.code === 10000) {
                    return;
                }
                if (res.code !== 0) {
                    wx.showModal({
                        title: '无法登录',
                        content: res.msg,
                        showCancel: false
                    })
                    return;
                }
                getApp().globalData.aid = res.data;
                wx.setStorageSync('aid', res.data);
            })
        }
    })
}

module.exports = {
    login: login
}