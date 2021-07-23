using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;
using System.Net.Sockets;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;
using System.Text.RegularExpressions;
using MySql.Data.MySqlClient;

namespace Forms1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (txtUserName.Text=="your_user_name" && txtPassword.Text=="your_password")
            {
                this.Hide();

            }
            else
            {
                MessageBox.Show("The Username or Password is incorrect, try again!");
                txtUserName.Clear();
                txtPassword.Clear();
                txtUserName.Focus();
            }

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            new Forms2.Show();
            this.Hide();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
    private void buttonLogin_Click(object sender, EventArgs e)
    {
        UdpClient klienti = new UdpClient();
        Socket newSocket = new Socket(AddressFamily.InterNetwork,
                                    SocketType.Dgram, ProtocolType.Udp);
        IPEndPoint ep = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 12000);
        EndPoint tempRemote = (EndPoint)ep;
        klienti.Connect(ep);

        byte[] bytesend = Encoding.ASCII.GetBytes(textBoxUsername.Text + ' ' + txtPassword.Text);

        klienti.Send(bytesend, bytesend.Length);



        byte[] receivedData = klienti.Receive(ref ep);
        if (string.Equals(Encoding.ASCII.GetString(receivedData), "Wrong password/username"))
        {
            textBoxUsername.Text = "";
            txtPassword.Text = "";
            Console.WriteLine(Encoding.ASCII.GetString(receivedData));
            vlera.Text = Encoding.ASCII.GetString(receivedData);


        }

        Console.WriteLine(Encoding.ASCII.GetString(receivedData));
        vlera.Text = Encoding.ASCII.GetString(receivedData);

        X509Certificate2 cert = GetCertificateFromStore("CN=RootCA");
        if (cert == null)
        {
            Console.WriteLine("Certificate 'CN=CERT_SIGN_TEST_CERT' not found.");
            Console.ReadLine();
        }

        if (Validate())
        {
            string email = txtUserName.Text.Trim();
            string password = textBoxPassword.Text.Trim();
            DES des = new DES();


            string mesazhi = email + ":" + password + ":" + "hello";
            Console.WriteLine(mesazhi);
            byte[] encrytedData = des.Enkripto(mesazhi);

            byte[] IV = des.getIV();
            byte[] key = des.getKey();


            byte[] encryptedKey = EncryptDataOaepSha1(cert, key);

            Console.WriteLine(encryptedKey.Length);
            Console.WriteLine(Convert.ToBase64String(encryptedKey));

            Console.WriteLine(Convert.ToBase64String(key));
            Console.WriteLine(Convert.ToBase64String(DecryptDataOaepSha1(cert, encryptedKey)));



            string delimiter = ".";
            string fullmessageEncrypted = Convert.ToBase64String(IV) + delimiter + delimiter + Convert.ToBase64String(encrytedData);



            Console.WriteLine("dergojme :" + fullmessageEncrypted.Length);
            Console.WriteLine("IV:" + Convert.ToBase64String(IV));
            Console.WriteLine("Qelsi: " + Convert.ToBase64String(encryptedKey));
            Console.WriteLine("Mesazhi: " + Convert.ToBase64String(encrytedData));

            if (Encoding.UTF8.GetString(des.Dekripto(Convert.ToBase64String(receivedData))).Substring(0, 2) == "OK")
            {
                MessageBox.Show("OK");
            }
            else
            {
                MessageBox.Show("Error");
            }
        }

    }
    //


    public static byte[] DecryptDataOaepSha1(X509Certificate2 cert, byte[] data)
    {
        using (RSA rsa = cert.GetRSAPrivateKey())
        {
            return rsa.Decrypt(data, RSAEncryptionPadding.OaepSHA1);
        }
    }
    private static X509Certificate2 GetCertificateFromStore(string certName)
    {

        // Get the certificate store for the current user.
        X509Store store = new X509Store(StoreLocation.CurrentUser);
        try
        {
            store.Open(OpenFlags.ReadOnly);

            // Place all certificates in an X509Certificate2Collection object.
            X509Certificate2Collection certCollection = store.Certificates;
            X509Certificate2Collection currentCerts = certCollection.Find(X509FindType.FindByTimeValid, DateTime.Now, false);
            X509Certificate2Collection signingCert = currentCerts.Find(X509FindType.FindBySubjectDistinguishedName, certName, false);
            if (signingCert.Count == 0)
                return null;
            // Return the first certificate in the collection, has the right name and is current.
            return signingCert[0];
        }
        finally
        {
            store.Close();
        }

    }

    public static byte[] EncryptDataOaepSha1(X509Certificate2 cert, byte[] data)
    {
        // GetRSAPublicKey returns an object with an independent lifetime, so it should be
        // handled via a using statement.
        using (RSA rsa = cert.GetRSAPublicKey())
        {
            // OAEP allows for multiple hashing algorithms, what was formermly just "OAEP" is
            // now OAEP-SHA1.
            return rsa.Encrypt(data, RSAEncryptionPadding.OaepSHA1);
        }
    }

    private void labelGoToSignUp_Click(object sender, EventArgs e)
    {
        this.Hide();
        Form2 registerform = new Form2();
        registerform.Show();
    }

    private void labelGoToSignUp_Enter(object sender, EventArgs e)
    {
        labelGoToSignUp.ForeColor = Color.White;
    }

    private void textBoxUsername_TextChanged(object sender, EventArgs e)
    {

    }

    private void label1_Click_1(object sender, EventArgs e)
    {

    }
}
}
}
