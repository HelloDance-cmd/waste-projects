from Crypto.Cipher import DES
from Crypto.Util.Padding import pad, unpad
from Crypto.Random import get_random_bytes


# DES加密类
class DESCipher:
    def __init__(self, key):
        self.key = key
        self.des = DES.new(self.key, DES.MODE_ECB)  # 使用ECB模式

    # 加密方法
    def encrypt(self, plaintext):
        # 将明文转换为字节并填充到8字节的倍数
        padded_data = pad(plaintext.encode(), DES.block_size)
        # 加密数据
        encrypted_data = self.des.encrypt(padded_data)
        return encrypted_data

    # 解密方法
    def decrypt(self, encrypted_data):
        # 解密数据
        decrypted_data = self.des.decrypt(encrypted_data)
        # 去掉填充
        return unpad(decrypted_data, DES.block_size).decode()


# # 使用示例
if __name__ == "__main__":
    # 生成一个8字节的密钥
    key = get_random_bytes(8)

    # 创建DES加密对象
    des_cipher = DESCipher(key)

    # 明文
    plaintext = "Hello, World!"
    print(f"原始明文: {plaintext}")

    # 加密
    encrypted_data = des_cipher.encrypt(plaintext)
    print(f"加密后的数据: {encrypted_data.hex()}")

    # 解密
    decrypted_data = des_cipher.decrypt(encrypted_data)
    print(f"解密后的数据: {decrypted_data}")
