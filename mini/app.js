App({
    globalData: {
        aid: ''
    },
    onLaunch: function () {
        this.globalData.aid = wx.getStorageSync("aid");
    }
})