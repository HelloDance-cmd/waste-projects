import rsa
from rsa import PrivateKey

 # rsa加密
def rsa_encrypt(string: str) :
    # 生成公私钥
    pubkey, privkey = rsa .newkeys(512)

    print("公钥:\n%s\n私钥:\n:%s" %(pubkey, privkey))
    # 明文编码格式
    content = string.encode("utf-8")
    # 公钥加密
    crypto = rsa.encrypt(content, pubkey)
    return crypto, privkey


 # rsa解密
def rsa_decrypt(string: bytes, pk: PrivateKey):
    # 私钥解密
    content = rsa.decrypt(string, pk)
    con = content.decode("utf-8")
    return con

if __name__ == "__main__":
    _string, pk = rsa_encrypt("hello rsa!")
    print("加密后密文: \n%s" % _string)
    _content = rsa_decrypt(_string, pk)
    print("解密后明文: \n%s" % _content)
