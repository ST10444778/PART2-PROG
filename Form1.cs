using System.Media;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CyberSecurityChatbotGUI2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            try
            {
                SoundPlayer player = new SoundPlayer("greeting.wav");
                player.Play();
            }
            catch
            {
                MessageBox.Show("Audio file could not play.");
            }
        }

        private void btnSend_Click(object sender, EventArgs e)
        {
            string userInput = txtUserInput.Text.ToLower();

            if (string.IsNullOrWhiteSpace(userInput))
            {
                DisplayBotMessage("Please enter a message.");
            }
            else if (userInput.Contains("password"))
            {
                DisplayBotMessage("Use strong and unique passwords for every account.");
            }
            else if (userInput.Contains("phishing"))
            {
                DisplayBotMessage("Be careful of suspicious emails and unknown links.");
            }
            else if (userInput.Contains("privacy"))
            {
                DisplayBotMessage("Privacy helps protect your personal information online.");
            }
            else if (userInput.Contains("worried"))
            {
                DisplayBotMessage("It's understandable to feel worried about cybersecurity threats.");
            }
            else if (userInput.Contains("curious"))
            {
                DisplayBotMessage("Curiosity is great! Learning cybersecurity helps keep you safe online.");
            }
            else if (userInput.Contains("scam"))
            {
                DisplayBotMessage("Scams often try to trick you into giving personal or banking information.");
            }
            else if (userInput.Contains("vpn"))
            {
                DisplayBotMessage("A VPN helps protect your privacy on public networks.");
            }
            else if (userInput.Contains("2fa"))
            {
                DisplayBotMessage("Two-factor authentication adds an extra layer of security to your accounts.");
            }
            else if (userInput.Contains("safe browsing"))
            {
                DisplayBotMessage("Safe browsing means checking links carefully and avoiding suspicious websites.");
            }
            else if (userInput.Contains("firewall"))
            {
                DisplayBotMessage("A firewall helps block unauthorized access to your computer or network.");
            }
            else
            {
                DisplayBotMessage("I didn't understand that. Try asking something else.");
            }

            txtUserInput.Clear();
        }
        private void DisplayBotMessage(string message)
        {
            rtbChat.AppendText("Bot: " + message + "\n");
        }
    }
}
