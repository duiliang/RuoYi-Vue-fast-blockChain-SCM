<template>
  <div>
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
      <el-form-item label="手机号" prop="mobile">
        <el-input v-model="formData.mobile" placeholder="请输入手机号" :maxlength="11" show-word-limit clearable
          prefix-icon='el-icon-mobile' :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="多行文本" prop="field102">
        <el-input v-model="formData.field102" type="textarea" placeholder="请输入多行文本"
          :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="单行文本" prop="field101">
        <el-input v-model="formData.field101" placeholder="请输入单行文本" clearable :style="{width: '100%'}">
        </el-input>
      </el-form-item>
      <el-form-item label="时间选择" prop="field109">
        <el-time-picker v-model="formData.field109" format="HH:mm:ss" value-format="HH:mm:ss"
          :picker-options='{"selectableRange":"00:00:00-23:59:59"}' :style="{width: '100%'}"
          placeholder="请选择时间选择" clearable></el-time-picker>
      </el-form-item>
      <el-form-item label="密码" prop="field103">
        <el-input v-model="formData.field103" placeholder="请输入密码" clearable show-password
          :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="颜色选择" prop="field108" required>
        <el-color-picker v-model="formData.field108" size="medium"></el-color-picker>
      </el-form-item>
      <el-form-item label="上传" prop="field107" required>
        <el-upload ref="field107" :file-list="field107fileList" :action="field107Action"
          :before-upload="field107BeforeUpload">
          <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
        </el-upload>
      </el-form-item>
      <el-form-item label="计数器" prop="field104">
        <el-input-number v-model="formData.field104" placeholder="计数器"></el-input-number>
      </el-form-item>
      <el-row gutter="15">
      </el-row>
      <el-form-item label="按钮" prop="field105">
        <el-button type="primary" icon="el-icon-search" size="medium"> 主要按钮 </el-button>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        mobile: '',
        field102: undefined,
        field101: 'admin',
        field109: null,
        field103: 'admin123',
        field108: null,
        field107: null,
        field104: 2,
        field105: undefined,
      },
      rules: {
        mobile: [{
          required: true,
          message: '请输入手机号',
          trigger: 'blur'
        }, {
          pattern: /^1(3|4|5|7|8|9)\d{9}$/,
          message: '手机号格式错误',
          trigger: 'blur'
        }],
        field102: [{
          required: true,
          message: '请输入多行文本',
          trigger: 'blur'
        }],
        field101: [{
          required: true,
          message: '请输入单行文本',
          trigger: 'blur'
        }],
        field109: [{
          required: true,
          message: '请选择时间选择',
          trigger: 'change'
        }],
        field103: [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }],
        field104: [{
          required: true,
          message: '计数器',
          trigger: 'blur'
        }],
      },
      field107Action: 'https://jsonplaceholder.typicode.com/posts/',
      field107fileList: [],
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
    field107BeforeUpload(file) {
      let isRightSize = file.size / 1024 / 1024 < 2
      if (!isRightSize) {
        this.$message.error('文件大小超过 2MB')
      }
      return isRightSize
    },
  }
}

</script>
<style>
.el-upload__tip {
  line-height: 1.2;
}

</style>
