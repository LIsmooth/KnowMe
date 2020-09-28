const KM = require('./KMAPI.js');

async function login() {
    wx.login({
        success: function (res) {
            KM.login_wx(res.code).then(function (res) {
                if (res.code !== 0) {
                    wx.showModal({
                        title: '无法登录',
                        content: res.errorMsg,
                        showCancel: false
                    })
                    return;
                }
                getApp().globalData.token = res.data.token;
                wx.setStorageSync('token', res.data.token);
                wx.setStorageSync('expiration', res.data.expiration);
            })
        }
    })
}
function passCodeFilter(res){
    if(res.code === 2000) {
        wx.removeStorageSync('token');
        wx.showModal({
            title: '无法登录',
            content: res.errorMsg + ' 请重新进入小程序',
            showCancel: false
        })
        return false;
    }
    return true;
}

module.exports = {
    login: login,
    passCodeFilter: passCodeFilter
}