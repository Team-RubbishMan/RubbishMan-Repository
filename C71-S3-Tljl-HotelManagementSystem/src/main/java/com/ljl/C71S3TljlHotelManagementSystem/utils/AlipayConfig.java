package com.ljl.C71S3TljlHotelManagementSystem.utils;

/**
 * 支付宝配置
 * @author Da
 *
 */
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101400687372";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCS/4imhu0IFAx95Pz2HJge2FCvonhJ867+CjFp7RYPW+kv6rQdeDdNATESmYGplpeFUHSFC8tpdawspWKJ/cg4Yph20nZzNXm6AwueyhlCMvIwwDKvKdEhk4TrV2ZK45zVdGHEQUBTfBb8PvusKSfk0h4p7a1xDISENSIwWjMb0CeQEgrh3eL+YBEYewvnbq6uJfUkgkeNxn3ZoKPElULFdTyC1J8aim6R4fSpNmXE6lsh57HlPUOZEkL5gIA4qS71v86BVHmveG7+ymwarA9YMdnSAJltydF37JcJz4U/LQSA7+Zo6iWHBhideySDpGglnrZMCuBWnx3KSZiwqrk3AgMBAAECggEAHFJ1rrgiZUMPoRYEkxqxSIgfC6f/CyiTV8j4+lK+xFjOFfhfman25bRMEyxWailkqj/1I0lBeOE+Oh/nW3T1JcABZitovQvZlzhM/dwsf6+3MCNn4I3rCFAW9Q0S3Wz7Y7kXuStlTHCFMTalYOdRE2pUe3mayEREKADgxHYskLf9tE9f7f7pXYCJWprqtCfK40//zmuwn0Oq+gzdcS0qZfVk1AyC7qiMGnhPjtOrGv/U+Vx5sUtSm6Ub2X/9Cd29cKKTmDAmVPm0LYXZY/THQc9SQSWsvKBRYGZGqmAAG/z+SMmC0uq28f0RBUXCbJRe90aSGQYmpf7lhxLLYtGw2QKBgQD/4eRvIxqqLZ0PFsvo4l4dZil4DI2VnZSpi06EYn0HxXBS8y9r3X/MqkvEGDMR7LCVIvjcZ40/97Wzs9XMn/lVXxWdFI+QbXMgUgwgWG2md1c5cEE+Ju7/xp30L4kdA6zAW11D3NI+NVIGouEcWXjMdOygKlk/8FVWnYUtwEUYuwKBgQCTENR1a3W6MiPMhVaNqN5jcIQuI1b7jdwbG8fnlpePVmQFpuSJW+i9NqBtclBEztw/+w0u3Q5kRvcoxk8IJFvt+gHVPmMuC4sxnhWtvz1kQ6M3X4n/aLtFzsCIxF2XP4NiA8zpDTUpayB0dpTt0miFQQkn4S1I0BZVDZRMVUdntQKBgE0tng/jX6yKm3+smY5BkK9/W+yopJ/G6ssEiIcniZypcYqjbN807NIXX0jjH6w9Xrls1fDsjs8HcNel20ufyL12M3ewdujSClJqTNwIr/Hwtu9NK3CKn7Wn+4ZmPA3zSMywAf5xATzgKkB0Kj+5wNSyQ5i/jTHa1HKOilfVUUH3AoGAIXp4Uw6Waz+UxK8p5++kSJDJllM3Lua5T3aAiGjQsbGh7WNzrQ0+KyyvUpruSOuqWepFswBhkVRSWXbjcOAOCVubZTbhjw7TrgTlvHrHd/apxiY6nOjzkM2jKL9C6vZrazmgQQFfs8EOT1TbTFRUtNj8Q5bQHz43hz8jHklfiu0CgYEAlyZdvlvzQvrgwaFjplQJiBXYfY+RAXPtCcE3QDmu0QU8gi7agvVI8JhTn+Ko17icFdUwc5x7mWLi66Wg7cc2PO0Jl2lmamYW1v/YI7rZGKT/X4DWvxgg17u1o7a0oC33ZDYKW3N+gsjqsYsPvk17azNLhsnJpxX66MQSjwaZFhc=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlUnuqfdeYYvu+4NzBfqkFRtPwp1YDSdv9sQqXa3pTTA4sF4FI0xIgzLjOgYDSMWTgHgh+f2qnJkhzsLyYnN5vucMUGingQK4qA9MDBEoHCqWRsswkIPtwc1DyCwt2ZoovcoYo/sBDAbnXMtkvJXxaukMKCKfLvgytsezwtLF1HyY7TAVZzuIunVcRjzhhNudkHk7iJEPq2k0nt2f/neb69AhgLJq1u3EtUJ0/S9YvBPFmFWVt+Ec4xkKlUl2IxZnNJR2CgI4GQAhzVjVPrzK7HRmeN0+4to2LhUFBuKt/WzkkKu8dg7igpnrMcEfNrzIgAXr4jwcPGnE/z9I279ymwIDAQAB";
    public static String notify_url = "http://localhost:80/alipay/alipayNotifyNotice";
    public static String return_url = "http://localhost:80/alipay/alipayReturnNotice";
    public static String sign_type = "RSA2";
    public static String charset = "UTF-8";
 	public static String format = "json";
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";//注意：沙箱测试环境，正式环境为：https://openapi.alipay.com/gateway.do
}